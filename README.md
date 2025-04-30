
# 💼 DLTE - Java Full Stack Development - Karthik

## 📝 Table of Contents

- 🔍 [About](#about)
- 🧱 [Architecture](#architecture)
- 💡 [Features](#features)
- 🚀 [Getting Started](#getting-started)
- 🧪 [Testing](#testing)
- 🛠️ [Technologies Used](#technologies-used)
- 📁 [Modules](#modules)
- 📅 [Weekly Progress](#weekly-progress)
- 🙌 [Acknowledgements](#acknowledgements)
- 📸 [Screenshots](#screenshots)
- 🔗 [Links](#links)

---

## 🔍 About

This full-stack Java-based **Banking Web Application** was developed during my internship at **Tietoevry Fintech India Pvt Ltd** (Feb–apr 2023).
It allows **bank officers** to:

- Search & manage **loan schemes** via REST and SOAP APIs.
- Log in securely with **3-attempt authentication**.
- Get deactivated after failed attempts; reactivation requires **admin access**.
- Utilize a reusable **DAO service layer** integrated into the frontend.

---

## 🧱 Architecture

```
+-----------------------+           +----------------------+
|   Frontend (JSP/JS)   | <-------> |   Backend (Spring)   |
+-----------------------+           +----------------------+
        | REST/SOAP APIs            |  DAO Layer (JPA)
        v                           v
    Web Server (Tomcat)       Oracle SQL DB
```

---

## 💡 Features

- 🔐 Login with account lock after 3 failed attempts
- 🧑‍💼 Admin dashboard to reactivate accounts
- 📡 SOAP API: List of Loan Schemes
- 🔍 REST API: Search by Loan ID or Type
- ✔️ Client-side validation
- ⚠️ Exception handling

---

## 🚀 Getting Started

1. Clone the repo:
   ```bash
   git clone https://github.com/karthikmc2148/DLTE-JavaFullStackDevelopment-Karthik.git
   ```
2. Import into IntelliJ or Eclipse
3. Set up Oracle DB using the schema in `DLTE-ORACLE DB`
4. Run the DAO Spring Boot service
5. Deploy the frontend on Tomcat
6. Access from browser and test login/search features

---

## 🧪 Testing

- ✅ REST API tested via **Postman**
- ✅ SOAP API tested via **SoapUI**
- ✅ Login/account lock flow tested
- ✅ Client validations checked

---

## 🛠️ Technologies Used

| Layer         | Tools/Tech                            |
|---------------|----------------------------------------|
| Frontend      | HTML, CSS, JSP, JavaScript, Servlets  |
| Backend       | Java, Spring Boot, JDBC, Hibernate, JPA |
| Database      | Oracle SQL                            |
| APIs          | REST, SOAP                            |
| Tools         | IntelliJ, Postman, SQL Developer, Tomcat, SoapUI |

---

## 📁 Modules

- Customer Login
- Admin Login
- Loan Listing (SOAP)
- Search Loans (REST)


---

## 📅 Weekly Progress

| Week | Topics |
|------|--------|
| 1️⃣ | HTML, CSS, JS Basics |
| 2️⃣ | Core Java: OOP, Threads, Exceptions |
| 3️⃣ | SQL, ER Diagram, Views |
| 4️⃣ | Java EE: Servlets, AJAX |
| 5️⃣ | Spring Boot, JPA, JDBC |
| 6️⃣ | API Dev with REST/SOAP |
| 7️⃣–9️⃣ | Schema Design, Auth |
| 🔟–12️⃣ | API Integration, Testing |

---

## 🙌 Acknowledgements

Thanks to:
- **Mr. Srikanth Hosur M** – project Guide, Tietoevry Fintech
- **Mr. Razak** - External trainer, Delite

---

## 📸 Screenshots

-**Login page**
![image](https://github.com/user-attachments/assets/1fca4cf8-8485-4ea9-8dbd-92fb9718829f)

-**Dashboard page**
![image](https://github.com/user-attachments/assets/7a37c8db-6a29-4404-9121-e47e6b810ee1)

-**Loan Schemes and customer details search page**
![image](https://github.com/user-attachments/assets/3bc65db9-0c3d-48d6-bc07-7ccb6054baef)




---

## 🔗 Links

- 🌐 GitHub: [Project Repo](https://github.com/karthikmc2148/DLTE-JavaFullStackDevelopment-Karthik)
- ✍️ Medium: [Blog Post](https://medium.com/@karthikmc24)
