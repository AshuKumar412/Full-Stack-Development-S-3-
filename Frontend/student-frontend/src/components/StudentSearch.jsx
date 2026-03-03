import { useState } from "react";
import { searchStudents, getAllStudents } from "../api/studentApi";

const StudentSearch = ({ setStudents }) => {

  const [value, setValue] = useState("");

  // Search by ID or Name
  const handleSearch = async () => {
    if (!value) return;

    const response = await searchStudents(value);
    setStudents(response.data);
  };

  // Clear input
  const handleClear = () => {
    setValue("");
  };

  // Get All Students
  const handleGetAll = async () => {
    const response = await getAllStudents();
    setStudents(response.data);
  };

  return (
    <div className="card">
      <div className="section-title">Search Student</div>

      <div className="input-group">
        <input
          placeholder="Enter ID or Name"
          value={value}
          onChange={(e) => setValue(e.target.value)}
        />
      </div>

      <div className="button-group">
        <button onClick={handleSearch}>Search</button>
        <button onClick={handleClear}>Clear</button>
        <button className="getall-btn" onClick={handleGetAll}>
          Get All
        </button>
      </div>
    </div>
  );
};

export default StudentSearch;