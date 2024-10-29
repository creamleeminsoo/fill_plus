# :computer:프로젝트 소개 
사용자들에게 영양제 제품을 서로 비교하는 기능을 제공하여 사용자의 선택을 서포트하여 향상된 경험을 제공하는 
어플입니다
## 목차
- [프로젝트 개발](#프로젝트-개발)
- [개발 환경](#개발-환경)
- [시장조사](#시장조사)
- [개발내용](#개발내용)

## 프로젝트 개발

**개발인원** : 3명


**개발일정**: 2023년 3월8일 ~ 2023년 6월 11일


![image](https://github.com/user-attachments/assets/6d783130-d23b-4034-b7a1-32f3a0e133cc)


**문제**: 영양제 선택에 어려움

**목적(why)** -> 쉽고 합리적인 영양제 선택을 위하여

**목표(what)** -> 영양제를 비교하는 기능을 만들어서 사용자에게 영양제의 성분등을 쉽게 간편하게 비교하여 선택을 도와준다.


## :low_brightness: 개발 환경 

- 개발언어 : kotlin
- DB: Firebase
- 디자인: pigma
- IDE: Android Studio
- API: DSLD API , chatGPT API

## 시장조사


![image](https://github.com/user-attachments/assets/eb6cb888-9210-480e-8f42-8f40ff8f9068)

8가지의 유사 어플리케이션을 기능별로 식별하고 6개 이상의 유사 어플리케이션에 같은 기능이 있는경우 **필수로 넣어야하는기능**


그리고 그이외는 **추가할 기능** 으로 기능별로 나눴습니다

## 개발내용

**Android용 레이아웃**

![image](https://github.com/user-attachments/assets/af8b14bb-5fe7-4b90-aef8-c4765db16616)


**회원가입시 회원정보를 DB에 저장**

![image](https://github.com/user-attachments/assets/37054897-f793-44c5-a509-59b1536d1d0e)

**DSLD API를 활용해 영양제 정보 추출**

![image](https://github.com/user-attachments/assets/315b226d-4c09-4084-9cf2-c22dd56bc3f2)

## 영양제 비교 기능

![화면_캡처_2024-08-17_142923](https://github.com/user-attachments/assets/271e71b1-68fc-4bc1-b97d-3829d1fea44d)

원하는 카테고리에 들어가서 비교하고 싶은 영양제 2개를 선택

![화면_캡처_2024-08-17_142956](https://github.com/user-attachments/assets/df191e2e-e686-4dd5-8980-f5166877d32f)

영양제 영양성분 함량을 원형그래프/막대그래프로 표시해주며

사용자가 더욱더 정확한 정보를 얻을수있도록 GPT API를 이용해 영양성분 비교



