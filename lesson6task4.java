package lesson6;

class ParkingSystem {

    int[] arr_free;

    public ParkingSystem(int big, int medium, int small) {
        this.arr_free = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if ((carType < 1) || (carType > 3))
            return false;
        return this.arr_free[carType - 1]-- > 0;
    }
};


public class lesson6task4 {

    public static void main(String[] args) {
        ParkingSystem park = new ParkingSystem(1,1,0);
        System.out.println(park.addCar(1));
        System.out.println(park.addCar(2));
        System.out.println(park.addCar(3));
        System.out.println(park.addCar(1));
    }

}
