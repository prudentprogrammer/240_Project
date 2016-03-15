public class Program1
{
public static void main(String l1[]) {
String l10,O11;
double l100;
double O101,l110,l111,O1000;
String l1001 = " ";
l1001 = JOptionPane.showInputDialog("P\154\145\141se c\150o\163e\040\157ne of the \157\160\164i\157ns:" + "\012" +"\141\051\105\156t\145r\0401\040\164o\040\143alc\165late \164\150e\040\141r\145a\040of \164\150e\040C\151\162c\154e" + "\012" + "b\051Enter 2 t\157\040c\141lc\165l\141\164e the \141\162\145a\040o\146 t\150e\040Tr\151\141n\147\154e" + "\012" + "c\051Enter 3\040t\157 \143a\154\143ulate the ar\145\141 \157\146\040th\145 \123quar\145" + "\012" + "\144)\105\156\164\145r\0404\040t\157\040\143\141\154c\165\154a\164e\040t\150e\040ar\145a\040o\146 \164h\145 R\145c\164a\156g\154e" + "\012" + "\145)\105\156\164\145r\0405\040t\157\040\143\141\154c\165\154a\164\145\040\164h\145 \141\162ea\040o\146\040t\150e\040Cub\145" + "\012" + "\146)\105\156\164e\162 \066 \164o \145xit the p\162\157gr\141m");
l100 = Double.parseDouble(l1001);
while (l100 != 6) {
if (l100 == 1) {
l10 = JOptionPane.showInputDialog("\105n\164\145\162\040t\150e\040v\141\154\165\145\040o\146\040r\141\144iu\163");
O101 = Double.parseDouble(l10);
l111 = Math.PI * O101 * O101;
JOptionPane.showMessageDialog(null, "\124\150\145\040\141r\145a\040of\040\164\150e Ci\162\143l\145\072\040\040 \040" + l111, "result", JOptionPane.INFORMATION_MESSAGE);
} else
if (l100 == 2) {
l10 = JOptionPane.showInputDialog("Ent\145r\040\164\150e\040v\141l\165e \157\146\040\154en\147ht");
O11 = JOptionPane.showInputDialog("\105\156\164\145\162 \164h\145 value of\040width");
O1000 = Double.parseDouble(l10);
l110 = Double.parseDouble(O11);
l111 = (l110 * O1000) / 2;
JOptionPane.showMessageDialog(null, "T\150e area \157f\040t\162i\141\156g\154e:     " + l111, "re\163ult", JOptionPane.INFORMATION_MESSAGE);
} else
if (l100 == 3) {
l10 = JOptionPane.showInputDialog("\105\156\164\145\162 \164h\145 value\040of lengt\150");
O1000 = Double.parseDouble(l10);
l111 = O1000 * O1000;
JOptionPane.showMessageDialog(null, "\124he area \157f \164h\145 \163\161uare:    " + l111, " re\163ul\164", JOptionPane.INFORMATION_MESSAGE);
} else
if (l100 == 4) {
l10 = JOptionPane.showInputDialog("\105\156\164er t\150e\040v\141lu\145\040\157f len\147\164h");
O11 = JOptionPane.showInputDialog("E\156\164er the\040v\141l\165e \157\146 width");
O1000 = Double.parseDouble(l10);
l110 = Double.parseDouble(O11);
l111 = l110 * O1000;
JOptionPane.showMessageDialog(null, "T\150e are\141\040o\146 \164h\145 rectangle:     " + l111, "\162\145\163\165\154t", JOptionPane.INFORMATION_MESSAGE);
} else
if (l100 == 5) {
l10 = JOptionPane.showInputDialog("E\156ter t\150\145\040v\141l\165\145\040of lengt\150");
O1000 = Double.parseDouble(l10);
l111 = 6 * O1000;
JOptionPane.showMessageDialog(null, "T\150e area \157f\040t\150e\040\143\165\142e:  " + l111, "r\145sult", JOptionPane.INFORMATION_MESSAGE);
}
l1001 = JOptionPane.showInputDialog("P\154ease\040\143h\157s\145 \157ne of the options\072" + "\012" + "\141)\105\156\164e\162 \061 \164o c\141\154culat\145\040th\145 \141r\145a \157f\040th\145 \103i\162cl\145" + "\012" + "\142\051\105\156\164e\162 \062 to \143\141lculat\145\040th\145 \141re\141 \157f\040\164h\145 \124r\151an\147le" + "\012" + "c\051\105\156ter 3\040t\157 \143alc\165\154ate th\145\040ar\145a\040of\040t\150\145 \123q\165a\162e" + "\012" + "\144)Ente\162\0404\040t\157 \143alc\165\154ate th\145\040a\162\145\141\040o\146 \164\150e\040R\145c\164a\156g\154e" + "\012" + "\145)Ent\145\162 \065 \164o\040\143\141\154\143ula\164\145 \164\150\145\040a\162ea\040o\146 \164h\145 C\165b\145" + "\012" + "\146)\105\156\164e\162 \066 \164o \145\170it t\150e\040\160r\157\147r\141m");
l100 = Double.parseDouble(l1001);
}
System.out.println("\120r\157\147\162a\155 \164e\162mi\156a\164ed\012");
System.exit(0);
}
}