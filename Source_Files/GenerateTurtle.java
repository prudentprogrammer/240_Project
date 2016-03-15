void generate(Graphics g, float x, float y, float width, float height,
              float angle, int level) {
  float x1;
  float y01;

  turtle_x = x;
  turtle_y = y;
  turtle_r = height;
  step();
  x1 = turtle_x;
  y01 = turtle_y;
  level--;
  
  if (level < 3) {
    g.setColor(Color.green);
    drawbranch(g, width, (int) x, w1H - (int) y, (int) x1, w1H - (int) y01);
  } else {
    g.setColor(Color.white);
    drawbranch(g, width, (int) x, w1H - (int) y, (int) x1, w1H - (int) y01);
  }

  if (level > 0) {
    turtle_theta = point(x, y, x1, y01);
    turn(left_angle);
    generate(g, turtle_x, turtle_y, left_width_factor * width,
             left_height_factor * height, left_angle, level);
    turtle_theta = point(x, y, x1, y01);
    turn(-right_angle);
    generate(g, x1, y01, left_width_factor * width,
             left_height_factor * height, right_angle, level);

  }
}