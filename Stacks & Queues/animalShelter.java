import java.util.*;
public class animalShelter {
    int id;
    String name, type;
    animalShelter(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<animalShelter> queue = new LinkedList<>();
        int id = 0;
        do {
            System.out.println("What operation do you want to perform");
            System.out.println("1. Add Animal \n 2. Adopt Animal \n 3. Peek Animal \n 4. Exit");
            int operation = sc.nextInt();
            if (operation == 1) {
                System.out.println("Enter the name of the animal");
                String name = sc.next();
                System.out.println("Enter the type of the animal");
                String type = sc.next();
                queue.add(new animalShelter(++id, name, type));
            } else if (operation == 2) {
                if (queue.isEmpty()) {
                    System.out.println("Queue is Empty");
                } 
                else {
                    System.out.println("Enter the type of animal to be adopted");
                    System.out.println("1. Dog \n 2. Cat \n 3. Any");
                    int t = sc.nextInt();
                    if(t == 1 || t == 2)
                    {   
                        String typ = t == 1 ? "Dog" : "Cat";
                        animalShelter animal = queue.peek();
                        Queue<animalShelter> newQueue = new LinkedList<>();
                        boolean found = false;
                        while (!queue.isEmpty()) {
                            animal = queue.poll();
                            if (animal.type.equals(typ)) {
                                System.out.println(animal.name + " is adopted");
                                found = true;
                                break;
                            }
                            newQueue.add(animal);
                        }
                        if(!found)
                        {
                            System.out.println("No " + typ + " found");
                        }
                        while(!queue.isEmpty())
                        {
                            newQueue.add(queue.poll());
                        }
                        while(!newQueue.isEmpty())
                        {
                            queue.add(newQueue.poll());
                        }
                    }
                    else
                    {
                            animalShelter animal = queue.poll();
                            System.out.println(animal.name + " is adopted");
                            continue;
                    }
                }
            } else if (operation == 3) {
                if (queue.isEmpty()) {
                    System.out.println("Queue is Empty");
                } else {
                    animalShelter animal = queue.peek();
                    System.out.println(animal.name + " is at the front of the queue");
                }
            } else {
                break;
            }
        } while (true);
    }
}
