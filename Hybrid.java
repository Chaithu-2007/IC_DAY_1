class UniversityMember {
    int memberId;

    void checkIn() {
        System.out.println("Member checked in");
    }
}

class Staff extends UniversityMember {
    String department;

    void attendMeeting() {
        System.out.println("Attending meeting");
    }
}

class Professor extends Staff {
    String subject;

    void conductLecture() {
        System.out.println("Teaching: " + subject);
    }
}

class AdminOfficer extends Staff {
    String officeRoom;

    void processFiles() {
        System.out.println("Processing files in: " + officeRoom);
    }
}

public class Hybrid
{
    public static void main(String[] args) {

        Professor p = new Professor();
        p.memberId = 101;
        p.department = "CSE";
        p.subject = "Java";

        AdminOfficer a = new AdminOfficer();
        a.memberId = 102;
        a.department = "Administration";
        a.officeRoom = "Room 10";

        System.out.println("Professor Details:");
        p.checkIn();
        p.attendMeeting();
        p.conductLecture();

        System.out.println("\nAdmin Officer Details:");
        a.checkIn();
        a.attendMeeting();
        a.processFiles();
    }
}