public class HelloWorld {
    public static void main(String[] args){
        // System.out.println("Olá " + args[0] + ", tudo bem?");
        String ambiente = args[0];
        if (ambiente.equalsIgnoreCase("DEV")){
            System.out.println("Executando em DEV");
        }else if (ambiente.equalsIgnoreCase("TEST")){
            System.out.println("Executando em TEST");
        }else{
            System.out.println(ambiente);
        }
    } 
}
