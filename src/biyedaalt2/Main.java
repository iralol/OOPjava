package biyedaalt2;

public class Main {
        public static void main(String[] args) {
        
        System.out.println(" Employee System Demo \n");

        // Engineers
        Engineer eng1 = new Engineer("Bat-Erdene", 26, 3500, 
                                "Backend", "Java / Spring Boot", 3);
        
        Engineer eng2 = new Engineer("Nominchimeg", 24, 3200, 
                                "Frontend", "React / TypeScript", 1);

        eng1.display();
        eng2.display();

        // Managers
        Manager mgr1 = new Manager("Gantulga", 38, 5500, 
                                "Engineering", 8, 0.20);
        
        Manager mgr2 = new Manager("Oyuntuya", 42, 6200, 
                                "Operations", 12, 0.25);

        mgr1.display();
        mgr2.display();

        }
}