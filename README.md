# @Channel: Full-Stack Social Microblogging Platform

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)

> Implementation of a full-stack Java microblogging platform using external APIs, structured into front-end, back-end, and DB components, using the Spring and Bootstrap frameworks.

## 📖 **Context**

This project was developed for the **Web System Design and Archietecture** examination of Prof. **Marco La Cascia**, during the **2024/2025** Academic Year at the **Università degli Studi di Palermo**, **Computer Engineering (LM-32, 2035)** course.

## 👥 **Author**
_Andrea Spinelli_

## 🛠️ **Technologies Used**

*   **Languages:** Java EE, JavaScript, HTML
*   **Frameworks/Libraries:** Spring, Thymeleaf, Bootstrap
*   **Databases:** MySQL
*   **Other:** Git

## 🚀 **Installation and Startup**

To run this project, you will need a Java Development Kit (JDK), a database server, and Maven. The easiest way to run it is by importing it into an IDE like IntelliJ IDEA.

### Prerequisites

*   **Java Development Kit (JDK) 17** or higher.
*   A **MySQL Server** (or PostgreSQL, depending on the JDBC driver in `pom.xml`).
*   **Apache Maven**.
*   An IDE like **IntelliJ IDEA** (Community or Ultimate).
*   [Git](https://git-scm.com/downloads/).

---
### Method 1: Running from IntelliJ IDEA (Recommended)

1.  **Clone the Repository**
    ```bash
    git clone https://github.com/A-rgonaut/LM-32_AtChannel_Full-Stack_Social_Microblogging_Platform.git
    ```

2.  **Set Up the Database**
    *   Make sure your MySQL server is running.
    *   Create a new database for the project. For example:
        ```sql
        CREATE DATABASE atchannel_db;
        ```

3.  **Configure the Application**
    *   Open the project folder.
    *   Navigate to `src/main/resources/` and open the `application.properties` file.
    *   Update the database connection details to match your local setup. Pay close attention to these properties:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/atchannel_db
        spring.datasource.username=your_db_username
        spring.datasource.password=your_db_password
        ```
    *   Spring Boot, with the `spring.jpa.hibernate.ddl-auto=update` property, will automatically create the necessary tables in the database the first time you run the application.

4.  **Open and Run in IntelliJ IDEA**
    *   Launch IntelliJ IDEA.
    *   Select **File > Open...** and choose the cloned repository folder.
    *   IntelliJ will automatically detect it as a Maven project and install all dependencies from the `pom.xml` file.
    *   Once dependencies are synced, navigate to `src/main/java/it/unical/mat/progettoweb/AtChannelApplication.java`.
    *   Right-click on the file and select **Run 'AtChannelApplication.main()'**.

5.  **Access the Application**
    The server will start (usually on port 8080). Open your web browser and go to `http://localhost:8080`.

---
### Method 2: Running from the Command Line

1.  **Follow steps 1-3** from the method above (Clone, Database Setup, Configuration).

2.  **Build with Maven**
    Open a terminal in the root directory of the project and run:
    ```bash
    mvn clean package
    ```
    This will create a JAR file in the `target/` directory.

3.  **Run the Application**
    Execute the JAR file using the `java` command:
    ```bash
    java -jar target/AtChannel-0.0.1-SNAPSHOT.jar
    ```    The application will start, and you can access it at `http://localhost:8080`.

## ✨ **Key Features**

"**@Channel**" is a full-stack social microblogging platform built with a modern Java technology stack. It allows users to register, post content, and interact with each other in a shared feed.

#### 1. Core User Functionality
*   **User Authentication**: Secure user registration and login system.
*   **Post Creation**: Users can create, edit, and delete their own posts.
*   **Social Feed**: A central timeline where users can see posts from everyone on the platform.
*   **User Profiles**: Public profiles for each user, showing their posts and information.
*   **Interactivity**: The ability to "like" posts and see the like count.
*   **External API Integration**: The application enriches user profiles or posts by fetching data from external APIs (e.g., for avatars, location, or other content).

#### 2. Technical Features
*   **Full-Stack Architecture**: The project is clearly divided into a backend, frontend, and database layer.
*   **Backend (Java & Spring Boot)**: The server-side logic is built with Spring Boot, utilizing:
    *   **Spring MVC**: To handle web requests through a Controller-based architecture.
    *   **Spring Data JPA**: To manage database operations seamlessly through Repository interfaces, mapping Java objects (Entities) to database tables.
    *   **Spring Security**: (Likely used) to handle authentication and authorization securely.
*   **Frontend (Thymeleaf & Bootstrap)**: The user interface is dynamically rendered on the server-side:
    *   **Thymeleaf**: A modern Java template engine that integrates with Spring to generate HTML.
    *   **Bootstrap**: A popular CSS framework used to create a clean, responsive, and mobile-friendly design.
*   **Database**: The application relies on a relational database (like MySQL or PostgreSQL) to persist user and post data.
