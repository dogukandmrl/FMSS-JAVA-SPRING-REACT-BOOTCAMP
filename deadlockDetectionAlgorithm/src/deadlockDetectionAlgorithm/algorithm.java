package deadlockDetectionAlgorithm;

import java.util.Scanner;

public class algorithm {
    private int proses,kaynak;
    private int
            max[][],
            allocate[][],
            need[][],
            available[];

    public static void main(String[] args) {
        algorithm algo = new algorithm();
    algo.getInput();
    algo.setShow();
    algo.getCall();
    }

    public void getCall() {
        int finish[],temp,flag =1,k,c1=0;

        int dead[];
        int safe[];
        int prosesIndex,kaynakIndex;

        finish = new int[100];
        dead = new int[100];
        safe = new int[100];
            //tamamlanmış matris güvenlil algoritmasından false olarak ayarlandı
        for(prosesIndex =0;prosesIndex<proses;prosesIndex++){
            finish[prosesIndex] =0;
        }
        //İhtiyaç [i,j] = Max[i,j] – Atama[i,j] işlemi by satırda gerçekleştirildi
        for (prosesIndex=0;prosesIndex<proses;prosesIndex++){
            for (kaynakIndex=0;kaynakIndex<kaynak;kaynakIndex++){
                need[prosesIndex][kaynakIndex] = max[prosesIndex][kaynakIndex]-allocate[prosesIndex][kaynakIndex];
            }
        }
        // Ardından tamamlanmış matris true olana kadar aşağıdaki işlemler gerçekleştirildi
        while (flag==1){
            flag =0;
            for (prosesIndex=0;prosesIndex<proses;prosesIndex++){
                int c=0;
                for(kaynakIndex=0;kaynakIndex<kaynak;kaynakIndex++){
                    // Güvenlik algoritmasını yerine getirecek durumlar arandı eğer şartlar sağlanırsa algoritma devam etti.
                    if((finish[prosesIndex]==0)&&(need[prosesIndex][kaynakIndex]<=available[kaynakIndex])){
                        c++;
                        if(c==kaynak){
                            for(k=0;k<kaynak;k++){
                                //Çalışan= Çalışan+ Atanmış işlemi gerçekleştirildi ve true değer döndürüldü
                                available[k]+=allocate[prosesIndex][kaynakIndex];
                                finish[prosesIndex]=1;
                                flag=1;
                            }
                            if(finish[prosesIndex]==1){
                                prosesIndex=proses;

                            }
                        }
                    }
                }
            }
        }
        kaynakIndex=0;
        flag=0;
        for (prosesIndex=0;prosesIndex<proses;prosesIndex++){
            if (finish[prosesIndex]==0){
                dead[kaynakIndex]=prosesIndex;
                kaynakIndex++;
                flag=1;
            }
        }
        //tamamlanmış matris true döndürülürse sistem güvenli durumdadır ve ölümcül kilitlenme bulunmamaktadır.
        if (flag==1){
            System.out.println("\n\nSistem Olumcul Kitlenmede ve Kilitlenme Süreci\n");
            for (prosesIndex=0;prosesIndex<proses;prosesIndex++){
                System.out.println("P"+dead[prosesIndex]);
            }
        }
        else {
            System.out.println("Olumcul Kilitlenme Yoktur...");
        }
    }
    public void setShow() {
        // Girilen matrisleri bu method altında yazdırıldı.
        for(int prosesIndex=0;prosesIndex<proses;prosesIndex++){
            System.out.print("\nP"+(prosesIndex+1));
            System.out.println("       ");
            for (int kaynakIndex=0;kaynakIndex<kaynak;kaynakIndex++){
                System.out.print("  "+allocate[prosesIndex][kaynakIndex]);
            }
            System.out.println("      ");
            for (int kaynakIndex=0;kaynakIndex<kaynak;kaynakIndex++){
                System.out.print(""+max[prosesIndex][kaynakIndex]);
            }
            System.out.println("      ");
            if(prosesIndex==0){
                for (int kaynakIndex=0;kaynakIndex<kaynak;kaynakIndex++){
                    System.out.print("  "+available[kaynakIndex]);
                }
            }
        }
    }
    public void getInput(){
        // proses ve kaynak input işlemleri yapıldı
        Scanner sc = new Scanner(System.in);
        System.out.println("Proses Sayisini giriniz:");
        proses = sc.nextInt();
        System.out.println("Kaynak Sayisini giriniz");
        kaynak =sc.nextInt();

        // ihtiyaç maksimum istek, boş ve atanmış matrisler atandı
        need = new int[proses][kaynak];
        max  = new int[proses][kaynak];
        allocate = new int[proses][kaynak];
        available = new int[kaynak];

        // Girilen proses ve kaynak değerine göre matrisler kullanıcı tarafından girildi

        System.out.println("Atanmis matrisi giriniz: ");
        for (int prosesIndex = 0; prosesIndex <proses; prosesIndex++)
            for (int kaynakIndex = 0; kaynakIndex <kaynak; kaynakIndex++) {
                allocate[prosesIndex][kaynakIndex] = sc.nextInt();
            }
        System.out.println("Maksimum Istek Matrisini Giriniz:");
        for (int prosesIndex = 0; prosesIndex <proses; prosesIndex++)
            for (int kaynakIndex = 0; kaynakIndex <kaynak; kaynakIndex++){
                max[prosesIndex][kaynakIndex]=sc.nextInt();
            }
        System.out.println("Bos Matrisi giriniz:");
        for (int kaynakIndex=0;kaynakIndex<kaynak;kaynakIndex++){
            available[kaynakIndex] = sc.nextInt();


        }
    }

}





