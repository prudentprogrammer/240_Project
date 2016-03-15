public static void main(String[] args) {
        String txt = "";
        for(int i=0; i<6; i++){txt += txt .length() == 0 ? "h" : txt .length() == 2 ? "j" : i == 3 || i == 4 ? (txt .charAt(txt .length()-1) == ' ' ? "d" : " ") : i == 5 ? "å" : "e";}
        System.out.println(txt);
}