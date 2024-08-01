package com.example.fill_plus.main

import android.os.AsyncTask
import android.os.Bundle
import android.os.Message
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import com.example.fill_plus.R
import com.example.fill_plus.barChart
import com.example.fill_plus.barChart2
import com.example.fill_plus.pieChart
import com.example.fill_plus.pieChart2
import java.io.IOException

class MainActivity5 : AppCompatActivity() {
    //private var gpt_View: TextView? = null
    var messageList: MutableList<Message?>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        var database = FirebaseDatabase.getInstance()
        var ref = database.getReference("dsld/nutrient_1000/nutrients")
        var ref2 = database.getReference("dsld/nutrient_1002/nutrients")

        var new1 = database.getReference("dsld/nutrient_1000")
        var new2 = database.getReference("dsld/nutrient_1002")

        pieChart = findViewById(R.id.pieChart)
        pieChart2 = findViewById(R.id.pieChart2)
        barChart = findViewById(R.id.barChart)
        barChart2 = findViewById(R.id.barChart2)
        messageList = ArrayList()

        barChart.setNoDataText("")
        barChart2.setNoDataText("")

        val button_gpt = findViewById<Button>(R.id.button_gpt)
        val gpt_View = findViewById<TextView>(R.id.gpt_View)
        gpt_View.setMovementMethod(ScrollingMovementMethod())
        button_gpt.setOnClickListener {
            val jsonData1 = new1
            val jsonData2 = new2


            val prompt = "Compare the two supplements supplement1 : $jsonData1, supplement2: $jsonData2 "

            val callback = object : gptClient.CompletionCallback {
                override fun onCompletion(response: String) {
                    // 결과 처리
                    runOnUiThread {
                        gpt_View.text = response

                    }
                }

                override fun onError(error: IOException) {
                    // 오류 처리
                    error.printStackTrace()
                }
            }

            gptClient.generateText(prompt, callback)
        }







        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // 데이터 순회하며 처리
                pieChart = findViewById(R.id.pieChart)
                val entries = ArrayList<PieEntry>()
                for (childSnapshot in snapshot.children) {
                    val key = childSnapshot.key.toString()
                    val value = childSnapshot.value.toString()
                    val entry = PieEntry(value.replace("\\D+".toRegex(), "").toFloat(), key)
                    entries.add(entry)
                }
                val dataSet = PieDataSet(entries, "Pie Chart")
                dataSet.colors = ColorTemplate.MATERIAL_COLORS.toList()
                val data = PieData(dataSet)
                pieChart.data = data
                pieChart.setUsePercentValues(true)
                pieChart.description.isEnabled = false
                pieChart.invalidate()

            }
            override fun onCancelled(error: DatabaseError) {
                // 에러 처리
                println("Failed to read value: ${error.message}")
            }

        }) // ')'가 추가되었습니다.


        ref2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // 데이터 순회하며 처리
                pieChart2 = findViewById(R.id.pieChart2)
                val entries2 = ArrayList<PieEntry>()
                for (childSnapshot in snapshot.children) {
                    val key2 = childSnapshot.key.toString()
                    val value2 = childSnapshot.value.toString()
                    val entry2 = PieEntry(value2.replace("\\D+".toRegex(), "").toFloat(), key2)
                    entries2.add(entry2)
                }
                val dataSet2 = PieDataSet(entries2, "Pie Chart2")
                dataSet2.colors = ColorTemplate.MATERIAL_COLORS.toList()
                val data = PieData(dataSet2)
                pieChart2.data = data
                pieChart2.setUsePercentValues(true)
                pieChart2.description.isEnabled = false
                pieChart2.invalidate()
            }
            override fun onCancelled(error: DatabaseError) {
                // 에러 처리
                println("Failed to read value: ${error.message}")
            }
        }) // ')'가 추가되었습니다.


        val button = findViewById<Button>(R.id.button)
        val 그래프변경 = findViewById<Button>(R.id.그래프변경)
        val My = findViewById<Button>(R.id.My)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        My.setOnClickListener {
            val intent = Intent(this, MainActivity10::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }

        그래프변경.setOnClickListener {
            if (그래프변경.text == "막대 그래프로 변경 (성분함량)") {
                그래프변경.text = "원형 그래프로 변경 (성분비율)"
                pieChart.clear()
                pieChart.setNoDataText("")
                //pieChart.invalidate()
                pieChart2.clear()
                pieChart2.setNoDataText("")
                //pieChart2.invalidate()


                ref.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var l = 0.0
                        val entries = ArrayList<BarEntry>()
                        val labels = ArrayList<String>() // 영양성분 이름을 저장할 리스트

                        for (childSnapshot in snapshot.children) {
                            val key = childSnapshot.key.toString()
                            val value = childSnapshot.value.toString()
                            val entry = BarEntry(l.toFloat(), value.replace("\\D+".toRegex(), "").toFloat())
                            entries.add(entry)
                            labels.add(key) // 영양성분 이름을 리스트에 추가
                            l = l + 1.2
                        }

                        val dataSet = BarDataSet(entries, "Bar Chart")
                        dataSet.colors = ColorTemplate.MATERIAL_COLORS.toList()

                        val data = BarData(dataSet)
                        barChart = findViewById(R.id.barChart)
                        barChart.data = data
                        barChart.setFitBars(true)
                        barChart.description.isEnabled = false

                        // X축 라벨 설정
                        barChart.xAxis.setLabelCount(labels.size) // 라벨의 개수 설정
                        barChart.xAxis.granularity = 1.2f // 라벨 간격 설정
                        barChart.xAxis.isGranularityEnabled = true // 라벨 간격 활성화
                        barChart.xAxis.valueFormatter = IndexAxisValueFormatter(labels)

                        barChart.invalidate()
                    }

                    override fun onCancelled(error: DatabaseError) {
                        println("Failed to read value: ${error.message}")
                    }
                })

                ref2.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var l = 0.0
                        val entries = ArrayList<BarEntry>()
                        val labels = ArrayList<String>() // 영양성분 이름을 저장할 리스트

                        for (childSnapshot in snapshot.children) {
                            val key = childSnapshot.key.toString()
                            val value = childSnapshot.value.toString()
                            val entry = BarEntry(l.toFloat(), value.replace("\\D+".toRegex(), "").toFloat())
                            entries.add(entry)
                            labels.add(key) // 영양성분 이름을 리스트에 추가
                            l = l + 1.2
                        }

                        val dataSet = BarDataSet(entries, "Bar Chart")
                        dataSet.colors = ColorTemplate.MATERIAL_COLORS.toList()

                        val data = BarData(dataSet)
                        barChart2 = findViewById(R.id.barChart2)
                        barChart2.data = data
                        barChart2.setFitBars(true)
                        barChart2.description.isEnabled = false

                        // X축 라벨 설정
                        barChart2.xAxis.setLabelCount(labels.size) // 라벨의 개수 설정
                        barChart2.xAxis.granularity = 1.2f // 라벨 간격 설정
                        barChart2.xAxis.isGranularityEnabled = true // 라벨 간격 활성화
                        barChart2.xAxis.valueFormatter = IndexAxisValueFormatter(labels)

                        barChart2.invalidate()
                    }

                    override fun onCancelled(error: DatabaseError) {
                        println("Failed to read value: ${error.message}")
                    }
                })


            } else {
                barChart.clear()
                barChart.setNoDataText("")
                barChart2.clear()
                barChart2.setNoDataText("")
                그래프변경.text = "막대 그래프로 변경 (성분함량)"

                ref.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        // 데이터 순회하며 처리
                        pieChart = findViewById(R.id.pieChart)
                        val entries = ArrayList<PieEntry>()
                        for (childSnapshot in snapshot.children) {
                            val key = childSnapshot.key.toString()
                            val value = childSnapshot.value.toString()
                            val entry = PieEntry(value.replace("\\D+".toRegex(), "").toFloat(), key)
                            entries.add(entry)
                        }
                        val dataSet = PieDataSet(entries, "Pie Chart")
                        dataSet.colors = ColorTemplate.MATERIAL_COLORS.toList()
                        val data = PieData(dataSet)
                        pieChart.data = data
                        pieChart.setUsePercentValues(true)
                        pieChart.description.isEnabled = false
                        pieChart.invalidate()

                    }
                    override fun onCancelled(error: DatabaseError) {
                        // 에러 처리
                        println("Failed to read value: ${error.message}")
                    }

                }) // ')'가 추가되었습니다.


                ref2.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        // 데이터 순회하며 처리
                        pieChart2 = findViewById(R.id.pieChart2)
                        val entries2 = ArrayList<PieEntry>()
                        for (childSnapshot in snapshot.children) {
                            val key2 = childSnapshot.key.toString()
                            val value2 = childSnapshot.value.toString()
                            val entry2 = PieEntry(value2.replace("\\D+".toRegex(), "").toFloat(), key2)
                            entries2.add(entry2)
                        }
                        val dataSet2 = PieDataSet(entries2, "Pie Chart2")
                        dataSet2.colors = ColorTemplate.MATERIAL_COLORS.toList()
                        val data = PieData(dataSet2)
                        pieChart2.data = data
                        pieChart2.setUsePercentValues(true)
                        pieChart2.description.isEnabled = false
                        pieChart2.invalidate()
                    }
                    override fun onCancelled(error: DatabaseError) {
                        // 에러 처리
                        println("Failed to read value: ${error.message}")
                    }
                }) // ')'가 추가되었습니다.
            }

        }


    }



    object gptClient {

        private const val API_URL = "url"
        private const val API_KEY = "key"

        interface CompletionCallback {
            fun onCompletion(response: String)
            fun onError(error: IOException)
        }

        fun generateText(prompt: String, callback: CompletionCallback) {
            GenerateTextTask(callback).execute(prompt)
        }

        private class GenerateTextTask(private val callback: CompletionCallback) :
            AsyncTask<String, Void, String>() {

            override fun doInBackground(vararg params: String): String? {
                val prompt = params[0]
                val client = OkHttpClient()
                val mediaType = "application/json; charset=utf-8".toMediaType()
                val body = RequestBody.create(mediaType, "{\"prompt\":\"$prompt\",\"max_tokens\":1000}")
                val request = Request.Builder()
                    .url(API_URL)
                    .post(body)
                    .addHeader("Authorization", "Bearer $API_KEY")
                    .build()

                try {
                    val response = client.newCall(request).execute()

                    return if (response.isSuccessful) {

                        response.body?.string()


                    } else {
                        throw IOException("Unexpected response code: ${response.code}")
                    }
                } catch (e: IOException) {
                    return null
                }
            }

            override fun onPostExecute(result: String?) {
                if (result != null) {
                    try {
                        val jsonResponse = JsonParser.parseString(result).asJsonObject
                        val choices = jsonResponse.getAsJsonArray("choices")
                        if (choices != null && choices.size() > 0) {
                            val content = choices[0].asJsonObject
                                .getAsJsonPrimitive("text")
                                .asString
                            callback.onCompletion(content)
                        } else {
                            callback.onError(IOException("No choices found in the response"))
                        }
                    } catch (e: JsonSyntaxException) {
                        callback.onError(IOException("Failed to parse the response"))
                    }
                } else {
                    callback.onError(IOException("Network request failed"))
                }
            }


        }
    }


}