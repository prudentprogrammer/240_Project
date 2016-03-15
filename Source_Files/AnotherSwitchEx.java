void Next(state) {
	switch (state) {
	case INITIAL:
	DoThing1();
	break;
	case THING1:
	DoThing2();
	break;
	case THING2:
	DoThing3();
	break;
	case THING3:
	// do nothing -- exit
	break;
	}
  }