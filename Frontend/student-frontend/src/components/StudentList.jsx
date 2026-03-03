import { deleteStudent } from "../api/studentApi";

const StudentList = ({ students, reload, onEdit }) => {

  const handleDelete = async (id) => {
    await deleteStudent(id);
    reload();
  };

  return (
    <div className="card">
      <div className="section-title">Student List</div>

      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Course</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {students.map((stu) => (
            <tr key={stu.id}>
              <td>{stu.id}</td>
              <td>{stu.name}</td>
              <td>{stu.course}</td>
              <td>
                <div className="action-buttons">
                  <button 
                    className="edit-btn"
                    onClick={() => onEdit(stu)}
                  >
                    Edit
                  </button>

                  <button
                    className="delete-btn"
                    onClick={() => handleDelete(stu.id)}
                  >
                    Delete
                  </button>
                </div>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default StudentList;