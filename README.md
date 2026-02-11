# MoodMate
People often struggle to decide what to do based on how they feel. MoodMate solves this by providing instant, personalized recommendations - music, movies, activities - based on the user’s current mood.

MoodMate is a lightweight backend service that generates **personalized recommendations** (music, activities, and food ideas) based on a user’s mood. Built using **Spring Boot**, the project focuses on clean backend architecture, REST APIs, validation, and structured error handling.

This project is being built in *phases*, with gradual complexity — from simple in-memory storage → PostgreSQL → AI-powered sentiment analysis.

---

### 🟩 Completed -> **Phase 1 — Core API (In-Memory Version)**  
**Goal:** Build the basic backbone of MoodMate without any database.  
**Focus Areas:**  
- Create Recommendation model (song, quote, activity, movie)  
- Store data in ArrayLists (temporary)  
- Build `/recommend?mood=` endpoint  
- Build optional `/recommend/{type}?mood=` endpoint  
- Add validation + basic error handling  
- Organize controllers, services, DTOs 

**Outcome:**  
A working MVP that returns mood-based recommendations from in-memory data.

**📌 API Endpoints**
1. *`/v1/api/recommendations/all`*
    - To get all the recommendations for all the mood types that are *currently* saves as a list
    - It returns a JSON object containing all the moods with music, activities and food
1. *`/v1/api/recommendations?mood=?`*
    - To get particular mood's recommendations with all - food, activity, and music options
    - Example: 
        `/v1/api/recommendations?mood=Happy`
        ```json
        {
            "dining": "Try a new ice cream flavor",
            "moodType": "Happy",
            "music": "Upbeat music",
            "stuffToDo": "Go for a walk in the park"
        }
        ```
    - Returns an error if the mood is undefined or null
        `/v1/api/recommendations?mood=saddd`
        ```json
        {
            "error": "Not Found",
            "message": "No recommendations found for the specified mood type: saddd",
            "path": "/v1/api/recommendations",
            "status": 404,
            "timestamp": "2026-02-10T22:52:36.615475"
        }
        ```
        `/v1/api/recommendations?mood=`
        ```json
        {
            "error": "Bad Request",
            "message": "Mood type cannot be null or empty",
            "path": "/v1/api/recommendations",
            "status": 400,
            "timestamp": "2026-02-10T22:53:15.412611"
        }
        ```
3. *`/v1/api/recommendations/{type_of_recommendation}?mood=?`*
    - To get one type of recommendation for the specified mood
    - Example:
        `/v1/api/recommendations/dinig?mood=stressed`
        ```html
        <h1>Order takeout from your favorite restaurant</h1>
        ```
    - Returns an error in the following cases:
        - Mood is undefined or null - output is similar to the above listed examples
        - type is undefined
        `/v1/api/recommendations/musikkkk?mood=stressed`
        ```json
        {
            "error": "Bad Request",
            "message": "Invalid recommendation type: musikkkk. \nValid types are: 'music' or 'todo' or 'dining' only.",
            "path": "/v1/api/recommendations/musikkkk",
            "status": 400,
            "timestamp": "2026-02-10T22:58:09.754679"
        }
        ```

<!-- 
#### 🔵 **Phase 2 — Database Integration (PostgreSQL)**  
**Goal:** Move from in-memory → persistent storage.  
**Focus Areas:**  
- Set up PostgreSQL  
- Convert lists → database tables  
- Create JPA Entities + Repositories  
- Implement CRUD operations (if needed)  
- Add user history table (optional)  
- Add integration tests (optional)  

**Outcome:**  
A more scalable, real backend powered by a proper database.

---

#### 🟧 **Phase 3 — Advanced Features (Pro Version)**  
**Goal:** Make MoodMate production-ready and impressive for recruiters.  
**Focus Areas:**  
- Add external APIs (Spotify, Quotes API, TMDB, etc.)  
- Use WebClient for API calls  
- Implement JWT Authentication (optional)  
- Add Swagger/OpenAPI docs  
- Add Redis caching for faster responses  
- Handle global exceptions cleanly  
- Add optional analytics (weekly mood trends)  
- Deploy on Render / Railway / Azure  

**Outcome:**  
A polished, cloud-ready backend project suitable for your portfolio.

---

#### 📝 Summary Table

| Phase | What You Build | Why It Matters |
|------|----------------|----------------|
| **Phase 1** | Core logic, API, in-memory data | Fast progress, clean structure |
| **Phase 2** | PostgreSQL + JPA | Real backend experience |
| **Phase 3** | Auth, caching, APIs, deployment | Industry-ready, portfolio shine |

--- -->

## Running the Project
```bash
mvn spring-boot:run
```

Servers run on `http://localhost:8080`
**OR**
After running the project, you can check out the Mood Mate AI folder and import the BRUNO files for testing on Bruno App.
Or you can just copy the layout and test it on Postman or whichever API testing tool you are comfortable with.



## 🛠️ Tech Stack

- **Java 21**
- **Spring Boot 3.x / Web MVC**
- **Maven**
- **JSON-based API responses**
- *Upcoming:* PostgreSQL, Spring Data JPA, JWT



## 🎯 Project Roadmap

#### **Phase 1 — Core API (✓ Completed)**
- Build basic endpoints  
- Custom exception handling  
- In-memory recommendations list  
- Clean project structure  

---

#### **Phase 2 — Data Persistence (Next)**
- Add PostgreSQL  
- Add JPA entities and repositories  
- Store recommendations in a real database  
- Add CRUD “admin” endpoints  

---

#### **Phase 3 — Recommendation Enhancements**
- Add mood synonyms  
- Add sentiment analysis  
- Add fuzzy string matching  
- Handle spelling mistakes (“sadd” → “sad”)  

---

#### **Phase 4 — Frontend UI (Optional)**
- Build a React frontend  
- Real-time recommendation fetching  
- UI with TailwindCSS  
- Deploy frontend (Vercel/Netlify)  

---

#### **Phase 5 — AI-Powered Upgrade**
- Integrate Gemini/OpenAI  
- Detect mood from user text  
- Deliver personalized suggestions  
- Enable multi-turn conversational flow  

---
