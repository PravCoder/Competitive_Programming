
class WateringPlants {
    public int wateringPlants(int[] plants, int capacity) {

        int bucket = capacity; // current amount of water we have
        int numSteps = 0;  // total number of steps
        // iterate from plant-o-indx to last plant-i-indx
        for (int i=0; i<plants.length; i++) {
            // we more than or equal the amount of water reiquired to water
            // plant-i, water it and increment steps
            if (bucket >= plants[i]) {
                numSteps += 1;
                bucket -= plants[i];
            }
            // if we dont, compute number of steps to travel to river and back
            // and icnrement 1 because we are going to water this plant.
            else if (bucket < plants[i]) {
                numSteps += (i+i+1);
                bucket = capacity; // refill bucket
                bucket -= plants[i]; // water plant
            }
        }
        
        return numSteps;
    }
}

// NOTE:  if you do not have enough water to completely water the next plant, return to the river to fully refill the watering can.

// 2079. Watering Plants
