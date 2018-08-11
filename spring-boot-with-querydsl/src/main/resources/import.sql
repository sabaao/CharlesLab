-- Users

INSERT INTO `user` (username,email) VALUES ('steve_jobs','sjobs@apple.com'),('jeff_bezos','jbezos@amazon.com'),('bill_gates','bgates@microsoft.com');

INSERT INTO admin (username,email) VALUES ('steve_jobs','sjobs@apple.com'),('jeff_bezos','jbezos@amazon.com'),('bill_gates','bgates@microsoft.com');

-- Department
INSERT INTO deptartment (dept_Id,dept_Name) VALUES ('1','marketing'),('2','RD');

-- Employee
INSERT INTO employee (emp_id,emp_name,dept_id) VALUES ('1','charles','1'),('2','sam','1'),('3','john','2'),('4','peter','2');

