package biyedaalt2;

public class Main {
        public static void main(String[] args) {
        System.out.println(" Ajilchidin system \n");
        // Engineer ba Manager class-ii object uusgej medeelel haruulna
        Engineer eng1 = new Engineer("Bat-Erdene", 26, 4800000, 
                                "Backend", "Java / Spring Boot", 3);
        Engineer eng2 = new Engineer("Nominchimeg", 24, 3800000, 
                                "Frontend", "React / TypeScript", 1);
        eng1.display();
        eng2.display();
        Manager mgr1 = new Manager("Gantulga", 38, 7500000, 
                                "Engineering", 8, 0.20);
        mgr1.display();
        }
}