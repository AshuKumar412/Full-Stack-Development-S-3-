import { useState, useEffect } from "react";
import { createStudent, updateStudent } from "../api/studentApi";

const StudentForm = ({ onStudentAdded, selectedStudent, clearSelection }) => {

  const [student, setStudent] = useState({
    id: "",
    name: "",
    course: ""
  });

  useEffect(() => {
    if (selectedStudent) {
      setStudent(selectedStudent);
    }
  }, [selectedStudent]);

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (selectedStudent) {
      await updateStudent(student.id, student);
      clearSelection();
    } else {
      await createStudent(student);
    }

    setStudent({ id: "", name: "", course: "" });
    onStudentAdded();
  };

  return (
    <div className="card">
      <div className="section-title">
        {selectedStudent ? "Update Student" : "Add Student"}
      </div>

      <form onSubmit={handleSubmit}>
        <div className="input-group">
          <input
            name="id"
            placeholder="ID"
            value={student.id}
            onChange={handleChange}
            required
            disabled={selectedStudent}   // ID cannot change in update
          />

          <input
            name="name"
            placeholder="Name"
            value={student.name}
            onChange={handleChange}
            required
          />

          <input
            name="course"
            placeholder="Course"
            value={student.course}
            onChange={handleChange}
            required
          />
        </div>

        <div className="button-group">
          <button type="submit">
            {selectedStudent ? "Update" : "Add"}
          </button>
        </div>
      </form>
    </div>
  );
};

export default StudentForm;