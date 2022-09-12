import java.io.IOException;
//nio
import java.nio.file.Path;
import java.nio.file.Files;
//util
import java.util.Scanner;
import java.util.List;

//ko chay dc netLine() 
public class Entry {
    
    public static void main(String[] args) {
        try {
            Scanner cin = new Scanner(System.in);
            char check, outButton; String search;
            //luu duong dan file data vao bien path
            Path path = Path.of("data.txt"); //path = data.txt;
            //doc file data -> luu du lieu vao list idol_data
            List<String>idol_data = Files.readAllLines(path); //idol_data = "[Eimi...66;45]"
            //System.out.println(path);
            while(true) {
                System.out.println("1) Tra cuu idol");
                System.out.println("2) Thoat");
                System.out.print("Moi ban chon: ");
                
                check = cin.next().charAt(0);
                if(check=='2') {break;}
                else if(check=='1') {
                    System.out.print("Nhap ten idol: ");
                    cin.nextLine();
                    search = cin.nextLine();
    
                    System.out.format("%-15s %-5s %-10s %-10s %-15s\n", 
                    "HO TEN", "TUOI", "CHIEU CAO", "CAN NANG", "TINH TRANG"
                    ); 

                    //xu li list idol_data
                    for(int i=0; i<idol_data.size(); i++) {
                        String each_idol[] = idol_data.get(i).split(";");
                        Idol my_idol = new Idol();
                        my_idol.name = each_idol[0];
                        my_idol.age = Integer.valueOf(each_idol[1]); //convert string to int
                        my_idol.height = Double.valueOf(each_idol[2]);
                        my_idol.weight = Double.valueOf(each_idol[3]); 
                        //print
                        search = search.toLowerCase();
                        my_idol.name = my_idol.name.toLowerCase();
                        if(my_idol.name.contains(search)) {
                            System.out.format("%-15s %-5s %-10s %-10s %-15s\n",
                                my_idol.name, my_idol.age, my_idol.height, my_idol.weight, my_idol.status()
                            );
                        }
                    }
    
                    System.out.println("________________________");
                    while(true) {
                        System.out.println("Nhan Q de quay lai");
                        outButton = cin.next().charAt(0);
                        if(outButton=='q' || outButton=='Q') {break;}
                        System.out.println("Nhap ko dung!");
                    }
                } 
                else {
                    System.out.println("Nhap ko dung!");
                }
            }
            //end loop here
            cin.close();
        } 
        catch (IOException e) {}
    }
}
