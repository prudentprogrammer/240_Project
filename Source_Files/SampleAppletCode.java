int sval, eval, stepv, i;
double d;
                if (/*someCondition*/)
                    {
                    sval = 360;//(all values multiplied by 20)
                    eval = -271;
                    stepv = -10;
                    }
                else if (/*someCondition*/)
                    {
                    sval = 320;
                    eval = -601;
                    stepv = -10;
                    }
                else if (/*someCondition*/)
                    {
                    sval = 0;
                    eval = -311;
                    stepv = -10;

                    }
                    else
                    {
                    sval = 360;
                    eval = -601;
                    stepv = -10;
                    }
                for (i = sval; i > eval; i = i + stepv)
                    {
                    d = i;
                    d = d / 20.0;
                    //do some more stuff in loop
                    }