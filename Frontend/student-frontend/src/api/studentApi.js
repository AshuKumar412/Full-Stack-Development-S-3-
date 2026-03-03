// import axios from "axios";

// const API_URL = "http://localhost:8080/api/student";

// export const getAllStudents = () =>
//   axios.get(`${API_URL}/getall`);

// export const createStudent = (student) =>
//   axios.post(`${API_URL}/add`, student);

// export const updateStudent = (id, student) =>
//   axios.put(`${API_URL}/update/${id}`, student);

// export const deleteStudent = (id) =>
//   axios.delete(`${API_URL}/del/${id}`);

// export const searchStudents = (value) =>
//   axios.get(`${API_URL}/search`, {
//     params: { value }
//   });

import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api/student";

/* Create axios instance */
const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    "Content-Type": "application/json"
  }
});

/* =========================
   STUDENT APIs
========================= */

// Get All Students
export const getAllStudents = () => {
  return api.get("/getall");
};

// Create Student
export const createStudent = (student) => {
  return api.post("/add", student);
};

// Update Student
export const updateStudent = (id, student) => {
  return api.put(`/update/${id}`, student);
};

// Delete Student
export const deleteStudent = (id) => {
  return api.delete(`/del/${id}`);
};

// Search by ID OR Name
export const searchStudents = (value) => {
  return api.get("/search", {
    params: { value }
  });
};