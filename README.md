# IIS-A2

# AI Scheduling Agent

### Project Status

Implemented:
- React frontend
- Spring Boot backend
- Calendar display
- Conflict detection
- Scheduling recommendations
- Suggestion mode
- Approval mode
- Autonomous mode
- Explanation panel
- Risk labels
- Undo function
- JSON storage

Unfinished:
- LLM integration
- Context-aware scheduling recommendations
- External calendar integration

### Technology Stack

Frontend:
- React (user interface)
- Vite (frontend build tool)
- Axios (API communication)

Backend:
- Java (core implementation)
- Spring Boot (REST API and application framework)
- Maven (dependency management)

Storage:
- JSON files (calendar and backup)

Technology Decisions:
No LLM integration to focus development on human oversight features.

### Running the Project

Frontend:
Inside frontend/ install dependencies "npm install".
Run "npm run dev".
Frontend runs at "http://localhost:5173".

Backend:
Inside backend/ run "./mvnw spring-boot:run".
Backend runs at "http://localhost:8080".

### Development Record

Stage 1: Calendar Prototype
- event model
- CRUD
- JSON

Stage 2: Oversight Modes
- suggestion mode
- approval mode
- autonomous mode

Stage 3: Intelligent Scheduling
- conflict detection
- scheduling recommendations

Stage 4: More Oversight Features
- explanation panel
- risk labels
- undo functionality

### AI Assisstance

Copilot AI was used for debugging frontend backend integration issues, including React component state management, API communication and CORS configuration. Also used for documentation structure of React and Spring Boot. Suggestions were tested and modified before implementation.