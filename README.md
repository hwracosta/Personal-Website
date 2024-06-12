# Personal Website
### By Harry Acosta & Jaydee Salazar

<div align="left" style="display: flex; justify-content: center; align-items: center; width: 100%;">
    <a href="https://raw.githubusercontent.com/hwracosta/Personal-Website/main/src/main/resources/static/images/GonxKillua.JPG?token=GHSAT0AAAAAACTMV6CMIPEHWPAKMDCQCZ2UZTJ33SA" target="_blank">
        <img src="https://raw.githubusercontent.com/hwracosta/Personal-Website/main/src/main/resources/static/images/GonxKillua.JPG?token=GHSAT0AAAAAACTMV6CMIPEHWPAKMDCQCZ2UZTJ33SA" width="400" alt="Project Banner">
    </a>
</div>

## Overview

This is a personal website project that showcases different pages such as a to-do list, hobbies, and a music page with a list of our current favorite songs. The project uses Spring Boot for the backend, PostgreSQL for the database, and Thymeleaf, HTML, and CSS for the frontend. This project is our machine problem for the CMSC 121 requirement.

## Technologies Used

- **Java**: The main programming language used for developing the backend.
- **Spring Boot**: A framework that simplifies the setup and development of new Spring applications.
- **Thymeleaf**: A Java template engine for processing and creating HTML, XML, JavaScript, CSS, and text.
- **PostgreSQL**: The database management system used to store application data.
- **HTML/CSS**: Used for structuring and styling the web pages.
- **JavaScript**: Used for adding interactive behavior to web pages.

## Features
#### Home Page
	Introduction to the website and navigation links to other pages.

#### To-Do List
	Allows users to manage their to-do items.
	Users can add, mark as complete, and delete to-do items.

#### Music Page
	Displays a list of favorite songs.
	Songs are grouped by team members.

#### Hobbies Page
	Showcases various hobbies of the team members.

## Project Structure

### Java Packages

- **controller**: Contains all the controllers that handle web requests and responses.
- **entity**: Contains all the entity classes that define the database tables.
- **repository**: Contains repository interfaces for database operations.
- **service**: Contains service classes that contain the business logic.

### Resources

- **static**: Contains static resources such as CSS files and images.
  - **css**: Contains the stylesheet files.
  - **images**: Contains image files used in the project.
- **templates**: Contains Thymeleaf templates for rendering the web pages.

## Setup Instructions

### Prerequisites
- Java Development Kit (JDK) 21 or higher
- Maven
- PostgreSQL
- IntelliJ IDEA

### Installation Links
- IntelliJ IDEA: [Download IntelliJ](https://www.jetbrains.com/idea/download/)
- PostgreSQL: [Download PostgreSQL](https://www.postgresql.org/download/)

### Running The Program

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/personal-website.git
    cd personal-website
    ```

2. **Set up PostgreSQL database**:
    - Create a database named `personalwebsite`.
    - Update the database configurations in `application.properties`:
      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/personalwebsite
      spring.datasource.username=your-username
      spring.datasource.password=your-password
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
      spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
      ```

3. **Run the application**:
    ```bash
    mvn spring-boot:run
    ```

4. **Access the application**:
    Open a web browser and navigate to `http://localhost:8080`.

## Thymeleaf

Thymeleaf is a modern server-side Java template engine for web and standalone environments. It allows dynamic content rendering with plain HTML and provides features like natural templating, meaning the templates can be viewed in a browser without being served from a server.

# Using The Program
## 1. To-Do List
	- Add a To-Do: Go to the to-do list page and use the input field to add a new to-do item.
	- Complete a To-Do: Mark a to-do item as complete by clicking on the checkbox next to it.
	- Delete a To-Do: Remove a to-do item by clicking the delete button next to it.

## 2. Music Page
You can insert sample data into the PostgreSQL database using SQL queries. Here are the general templates for inserting and updating data:
### Insert team members
```bash
INSERT INTO team_member (id, name) VALUES (1, 'Jaydee') ON CONFLICT (id) DO NOTHING;
```
### Insert songs for team members
```bash
INSERT INTO song (id, title, artist, album_artwork_url, team_member_id) 
VALUES (1, 'Fireflies', 'Owl City', 'https://is1-ssl.mzstatic.com/image/thumb/Music122/v4/f6/72/94/f67294c7-f123-c698-c70b-9e9aa1b0947f/09UMGIM22612.rgb.jpg', 1) 
ON CONFLICT (id) DO NOTHING;
```
### Update template, don't forget to change team_member_id and id as well
```bash
UPDATE song 
SET title = 'title', artist = 'artist', album_artwork_url = 'image link', team_member_id = 1 
WHERE id = 1;
```

## Contact Us
- **ACOSTA II, Harry William R.** | [hracosta@up.edu.ph](mailto:hracosta@up.edu.ph)
- **Salazar, Alexis Jaydee Migyel D.** | [adsalazar@up.edu.ph](mailto:adsalazar@up.edu.ph)
