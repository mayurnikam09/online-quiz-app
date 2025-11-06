📌 Overview

The Online Quiz App is a full-stack web application that allows users to take quizzes, view results, and track performance.
It’s designed for students, teachers, and administrators to create, manage, and analyze quizzes easily.

⚙️ Tech Stack

Frontend: Angular
Backend: Spring Boot, Hibernate
Database: MySQL
Authentication: JWT (JSON Web Token)
Build Tools: Maven
Version Control: Git & GitHub

🚀 Features

✅ User Registration and Login (JWT Authentication)
✅ Role-based Access (User & Admin)
✅ Quiz Creation and Management
✅ Auto-Graded Quiz Submissions
✅ Result Tracking and History
✅ Responsive UI built with Angular

🧩 Project Structure
OnlineQuizApp/
│
├── backend/
│   └── examportal/
│       ├── src/main/java/com/exam/examportal/
│       └── src/main/resources/
│
├── frontend/
│   └── ExamPortalSystem/
│       ├── src/
│       └── angular.json
│
└── README.md

🖥️ Setup Instructions
1️⃣ Backend Setup
cd backend/examportal
mvn spring-boot:run

2️⃣ Frontend Setup
cd frontend/ExamPortalSystem
npm install
ng serve --open


Then open:
👉 http://localhost:4200

📸 Screenshots (optional)

You can later add screenshots like:

![Dashboard](screenshots/dashboard.png)
![Quiz Page](screenshots/quiz-page.png)

💡 Future Enhancements

Add leaderboard system

Add question categories and difficulty levels

Implement timer-based quizzes

Export results in PDF/Excel
