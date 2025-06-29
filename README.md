
# Hospital Management System

## 📌 Project Overview

The **Hospital Management System** is a comprehensive Java-based desktop application designed to manage hospital operations efficiently. It supports the management of doctors, patients, staff, appointments, billing, and diagnostics, offering an intuitive GUI and database connectivity for real-time CRUD operations.

## 🎯 Features

- ➕ Add, view, update, and delete records for:
  - Doctors
  - Patients
  - Staff
  - Tests
- 📅 Manage appointments
- 🧾 Generate and manage bills
- 🖥️ Individual dashboards for doctors and staff
- 🗂️ Modular Java classes for each functionality
- 🔗 JDBC-based database connection
- 📦 Maven support via `pom.xml`

---

## 🗂️ Project Structure

```
HospitalManagementSystem/
│
├── Adddoctor.java
├── Addpatient.java
├── Addstaff.java
├── Addtest.java
├── Appointment.java
├── Bill.java
├── Connectiondb.java       # Handles JDBC connection
├── Doctordashboard.java
├── HospitalManagementSystem.java   # Main class
├── hmsproject.java         # Entry point (alternate)
├── Staffdashboard.java
├── Updatedoctor.java
├── Updatepatient.java
├── Updatestaff.java
├── Viewappoint.java
├── Viewdoctor_1.java
├── Viewpatient.java
├── Viewstaff.java
├── viewtest.java
├── carewell_collage.jpg    # Optional image asset
└── pom.xml                 # Maven configuration
```

---

## 🛠️ Technologies Used

- **Java (Swing)** – for GUI development
- **JDBC** – for MySQL or any relational DB connection
- **Maven** – dependency management (via `pom.xml`)
- **MySQL** – for storing hospital data
- **NetBeans / IntelliJ IDEA / Eclipse** – recommended IDEs

---

## 🚀 How to Run

1. **Clone or download** the project.
2. **Import into your IDE** (Eclipse/IntelliJ/NetBeans).
3. Ensure you have a **MySQL database** configured with appropriate tables.
4. Update database credentials in `Connectiondb.java`.
5. If using Maven, import the `pom.xml` to install dependencies.
6. Run `HospitalManagementSystem.java` or `hmsproject.java`.

---

## 🧾 Required Database Tables

You must create tables in your database for:

- `doctors`
- `patients`
- `staff`
- `appointments`
- `tests`
- `bills`

> You can modify `Connectiondb.java` to point to your DB.

---
#
