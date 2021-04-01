public class Main {
    public static void main(String [] args){
        majorFrame mf;
        mf = new majorFrame();

        mf.setVisible(true);
        mf.setSize(750,750);
        mf.setResizable(false);

        personInformation info;
        info = new personInformation();
        info.setVisible(true);
        info.setResizable(false);


        shapeServer shpsrv=new shapeServer();
        server srv=new server();
        shpsrv.start();
        srv.start();

        timeServer tsrv=new timeServer();
        tsrv.start();



    }
}
