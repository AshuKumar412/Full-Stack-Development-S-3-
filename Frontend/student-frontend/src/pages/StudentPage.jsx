import { useEffect, useState } from "react";
import { getAllStudents } from "../api/studentApi";
import StudentForm from "../components/StudentForm";
import StudentSearch from "../components/StudentSearch";
import StudentList from "../components/StudentList";

const StudentPage = () => {

  const [students, setStudents] = useState([]);
  const [selectedStudent, setSelectedStudent] = useState(null);

  const loadStudents = async () => {
    const response = await getAllStudents();
    setStudents(response.data);
  };

  useEffect(() => {
    loadStudents();
  }, []);

  return (
    <>
      <StudentForm
        onStudentAdded={loadStudents}
        selectedStudent={selectedStudent}
        clearSelection={() => setSelectedStudent(null)}
      />

      <StudentSearch setStudents={setStudents} />

      <StudentList
        students={students}
        reload={loadStudents}
        onEdit={setSelectedStudent}
      />
    </>
  );
};

export default StudentPage;