/*
 * @lc app=leetcode id=1603 lang=java
 *
 * [1603] Design Parking System
 *
 * https://leetcode.com/problems/design-parking-system/
 */

// @lc code=start
class ParkingSystem {

    // Number of empty slots for each type of car
    int[] capacity;

    public ParkingSystem(int big, int medium, int small) {
        this.capacity = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {

        // If space is available, allocate and return True
        if (this.capacity[carType - 1] > 0) {
            this.capacity[carType - 1]--;
            return true;
        }

        // Else, return False
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
// @lc code=end
