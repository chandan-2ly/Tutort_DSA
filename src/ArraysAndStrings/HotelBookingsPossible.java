package ArraysAndStrings;

import java.util.*;

//https://www.interviewbit.com/problems/hotel-bookings-possible/
public class HotelBookingsPossible {
    public static void main(String[] args){
        ArrayList<Integer> arrival = new ArrayList<>();
        arrival.add(1);
        arrival.add(2);
        arrival.add(3);
        ArrayList<Integer> depart = new ArrayList<>();
        depart.add(2);
        depart.add(3);
        depart.add(4);

        int k = 1;
        boolean result = isBookingPossible(arrival, depart, k);
        System.out.println(result);
    }

    private static boolean isBookingPossible(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);

        int personCount = 1;
        int i = 1, j = 0;

        while (i < arrive.size() && j < depart.size()){
            if(arrive.get(i) < depart.get(j)){
                personCount++;
                if(personCount > K) return false;
                i++;
            }
            else if(arrive.get(i) == depart.get(j)){
                i++;
                j++;
            }
            else {
                personCount--;
                if(personCount < 0)
                    personCount = 0;
                j++;
            }
        }

        return true;
    }
}
