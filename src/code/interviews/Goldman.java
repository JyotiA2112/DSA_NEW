package code.interviews;

import java.util.*;


class ParkingSpot{
    String name;
    Integer dist;

    ParkingSpot(String name, int dist){
        this.dist = dist;
        this.name = name;
    }

}

class Input{
    Integer vehicleNo;
    Character action;

    Input(Integer vehicleNo, Character action){
        this.vehicleNo = vehicleNo;
        this.action = action;
    }
}

class ItemComparator implements Comparator<ParkingSpot> {
    public int compare(ParkingSpot a, ParkingSpot b){
        return a.dist - b.dist;
    }
}

class Goldman {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
        Goldman g = new Goldman();
        List<Input> req = new ArrayList<>();
        List<ParkingSpot> spots = new ArrayList<>();

        req.add(new Input(1,'E'));
        req.add(new Input(2,'E'));
        req.add(new Input(1,'X'));
        req.add(new Input(3,'E'));

        spots.add(new ParkingSpot("A",1));
        spots.add(new ParkingSpot("B",1));
        spots.add(new ParkingSpot("C", 2));
        spots.add(new ParkingSpot("D", 2));
        spots.add(new ParkingSpot("E", 3));
        spots.add(new ParkingSpot("F", 3));


        g.findShortestPath(req, spots);
    }

    public void findShortestPath(List<Input> req, List<ParkingSpot> spots)
    {

        Map<Integer,ParkingSpot> vehicleSpot = new HashMap<>();
        PriorityQueue<ParkingSpot> queue = new PriorityQueue<>(new ItemComparator());


        for(int i=0; i<spots.size(); i++){
            queue.add(spots.get(i));
        }

            for(int i=0; i<req.size(); i++){

                if(req.get(i).action == 'E'){
                    ParkingSpot ps = queue.poll();
                    //takenMap.get("TAKEN").add(ps);
                    vehicleSpot.put(req.get(i).vehicleNo,ps); // i = 0
                    System.out.println("Parking spot :"+ps.name+" alloted to vehicle :"+req.get(i).vehicleNo);
                }
                if(req.get(i).action == 'X'){
                    ParkingSpot psAvailable = vehicleSpot.remove(req.get(i).vehicleNo); //?? i = 1
                    //available.put("AVAILABLE",psAvailable);
                    queue.add(psAvailable); //nlogn
                }
            }
    }

}


// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!
// We have a parking lot
// we have exit and entry
// we have vehicles coming in & going out parallely
// what we want to solve is : find the shortest distance from the entry for a vehicle to the available parking lot!
// Assuming single floor parking space. parking slots are not in a straight line. distance between every parking slot to be 1 unit
// Ditance from entry to lane A is 1 unit and distance from entry to Lane B is 1 unit.
//  ----------
// | a c e    | // Lane A
// -          -
// En         Ex   //g //d //h
// -          -
// | b g f    | // Lane B
//  ----------
// Input is an array of parking slots e.g. 26/100
// vehicles are entrying at time t and vehiclse are exiting at time t (t = 05:00) (05:00(2), 0:5:01(2, 3), 05:02(0, 2))
// Out is the shortest
//

//6 //7




//<Taken,List<>>
//<Available,List<A,B,C,D,E,F>>

//<Taken,List<A>>
//<Available,List<B,C,D,E,F>>

//<Taken,List<>>
//<Available,List<B,C,D,E,F>>



//


