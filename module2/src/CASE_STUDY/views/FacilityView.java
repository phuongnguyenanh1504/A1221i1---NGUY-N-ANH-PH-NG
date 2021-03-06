package CASE_STUDY.views;

import CASE_STUDY.controllers.EmployeeController;
import CASE_STUDY.controllers.FacilityController;
import CASE_STUDY.models.Facility.Facility;
import CASE_STUDY.models.Facility.House;
import CASE_STUDY.models.Facility.Room;
import CASE_STUDY.models.Facility.Villa;

import java.util.Scanner;

public class FacilityView {
    private static FacilityController facilityController=new FacilityController();
    /*public  static  Scanner input(){
        return new Scanner(System.in);
    }*/
    static Scanner scanner=new Scanner(System.in);
    private static final String[] listFacilityFunction={"1. Display list facility","2. Add new facility","3. Display list facility maintenance","4. Return main menu"};
    private static final String[] listRoomFunction={"1. Add new Villa","2. Add new House","3. Add new Room","4. Back to menu"};
    private static int choice;
    public static void displayMainMenu() {
        do{
            System.out.println("Facility Management Application");
            for (String li:listFacilityFunction){
                System.out.println(li);
            }
            choice= Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    facilityController.displayFacility();
                    displayMainMenu();
                    break;
                case 2:
                    displayRoomMenu();
                    break;
                case 3:
                    break;
                case 4:
                    FuramaView.displayMainMenu();
                    break;
                default:
                    System.out.println("No choice");
            }
        }
        while (choice<1||choice>4);
    }
    public static void displayRoomMenu() {
        do{
            System.out.println("Room Management Application");
            for (String li:listRoomFunction){
                System.out.println(li);
            }
            choice= Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    Facility villa= inputVillaInfor();
                    System.out.println("Th??ng tin: "+villa);
                    facilityController.addVilla(villa);
                    displayRoomMenu();
                    break;
                case 2:
                    Facility house= inputHouseInfor();
                    System.out.println(house);
                    facilityController.addHouse(house);
                    displayRoomMenu();
                    break;
                case 3:
                    Facility room= inputRoomInfor();
                    System.out.println(room);
                    facilityController.addRoom(room);
                    displayRoomMenu();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("No choice");
            }
        }
        while (choice<1||choice>4);
    }

    private static Room inputRoomInfor() {
        System.out.println("M???i nh???p th??ng tin d???ch v??? Room");
        System.out.println("M???i nh???p lo???i D???ch v???");
        String nameService=scanner.nextLine();
        System.out.println("M???i nh???p di???n t??ch");
        int square= Integer.parseInt(scanner.nextLine());
        System.out.println("M???i nh???p ti???n thu?? nh??");
        int cost=Integer.parseInt(scanner.nextLine());
        System.out.println("M???i nh???p s??? l?????ng ng?????i ??? t???i ??a");
        int maxPeople=Integer.parseInt(scanner.nextLine());
        System.out.println("M???i nh???p ki???u thu?? theo n??m,th??ng,ng??y, gi???");
        String type=scanner.nextLine();
        System.out.println("Nh???p d???ch v??? ??i k??m mi???n ph??");
        String freeService=scanner.nextLine();
        return new Room(nameService,square,cost,maxPeople,type,freeService);
    }

    private static House inputHouseInfor() {
        System.out.println("M???i nh???p th??ng tin d???ch v??? House");
        System.out.println("M???i nh???p lo???i D???ch v???");
        String nameService=scanner.nextLine();
        System.out.println("M???i nh???p di???n t??ch");
        int square= Integer.parseInt(scanner.nextLine());
        System.out.println("M???i nh???p ti???n thu?? nh??");
        int cost=Integer.parseInt(scanner.nextLine());
        System.out.println("M???i nh???p s??? l?????ng ng?????i ??? t???i ??a");
        int maxPeople=Integer.parseInt(scanner.nextLine());
        System.out.println("M???i nh???p ki???u thu?? theo n??m,th??ng,ng??y, gi???");
        String type=scanner.nextLine();
        System.out.println("M???i nh???p ti??u chu???n ph??ng");
        String roomStandard=scanner.nextLine();
        System.out.println("M???i nh???p s??? t???ng");
        int numFloor= Integer.parseInt(scanner.nextLine());
        return new House(nameService,square,cost,maxPeople,type,roomStandard,numFloor);
    }

    private static Villa inputVillaInfor() {
        System.out.println("M???i nh???p th??ng tin d???ch v??? Villa");
        System.out.println("M???i nh???p lo???i D???ch v???");
        String nameService=scanner.nextLine();
        System.out.println("M???i nh???p di???n t??ch");
        int square= Integer.parseInt(scanner.nextLine());
        System.out.println("M???i nh???p ti???n thu?? nh??");
        int cost=Integer.parseInt(scanner.nextLine());
        System.out.println("M???i nh???p s??? l?????ng ng?????i ??? t???i ??a");
        int maxPeople=Integer.parseInt(scanner.nextLine());
        System.out.println("M???i nh???p ki???u thu?? theo n??m,th??ng,ng??y, gi???");
        String type=scanner.nextLine();
        System.out.println("M???i nh???p ti??u chu???n c???a ph??ng");
        String standard= scanner.nextLine();
        System.out.println("M???i nh???p di???n t??ch h??? b??i");
        String squarePool=scanner.nextLine();
        System.out.println("M???i nh???p s??? t???ng");
        int numFloor= Integer.parseInt(scanner.nextLine());
        return new Villa(nameService,square,cost,maxPeople,type,standard,squarePool,numFloor);
    }
}
