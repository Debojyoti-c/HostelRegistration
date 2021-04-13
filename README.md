# HostelRegistration
The code follows a standard controller -> service -> repository -> datastore approach.
It reads from an input file and prints the o/p in console.

Input is read from `input.txt` which is kept in `resources` directory

####Assumptions:
There are 2 classes and 2 food types, if it increases then number of hostels
will increase.

Models:
Student and Hostel, food_type is taken care by FoodType enum

####DataStore:
It stores in-memory data
1) `Map<Integer, Student> studentMap`
This is used for duplicate registration check runtime

2) `Map<String, Hostel> hostelMap`
This is used to channeling the sudents to a particular hostel based on
type and class

3) `List<Student> unregisteredStudents`
This keeps a list of unregistered students

####Run Steps:
`mvn exec:java -Dexec.mainClass=HostelRegistration`

####Run Test Steps:
`mvn test`