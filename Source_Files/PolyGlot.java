//\u000a/*
#include <iostream>

#define private
#define public
#define static
#define void int
struct {
  std::ostream &println(const char *c) {
    return std::cout << c < < std::endl;
  }
} out;
//*/
/*\u002a/
import static java.lang.System.out;
public class Polyglot {
//*/
  public static void main(/*\u002a/String[] args//*/
      ) {
    out.println("Hello from whatever language this is!");
  }
/*\u002a/
}