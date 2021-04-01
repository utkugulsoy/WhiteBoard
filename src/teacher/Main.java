public class Main {
    public static void main(String [] args) {
        majorFrame mf=new majorFrame();

        mf.setVisible(true);
        mf.setSize(750,750);
        mf.setResizable(false);


        personInformation info;
        info = new personInformation();
        info.setVisible(true);
        info.setResizable(false);

        server srv=new server();
        srv.start();

        attendanceServer aSrv=new attendanceServer();
        aSrv.start();


    }
}
