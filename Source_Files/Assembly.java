if(i < ll1) goto _L6; else goto _L5
_L5:
    char ac[] = run(stop(lI1l));
    l7 = (long)ac.length << 32 & 0xffffffff00000000L ^ l7 & 0xffffffffL;
    if((int)((l7 & 0xffffffff00000000L) >> 32) != $5$)
    {
        l = (long)III << 50 & 0x4000000000000L ^ l & 0xfffbffffffffffffL;
    } else
    {
        for(l3 = (long)III & 0xffffffffL ^ l3 & 0xffffffff00000000L; (int)(l3 & 0xffffffffL) < ll1; l3 = (long)(S$$ + (int)(l3 & 0xffffffffL)) ^ l3 & 0xffffffff00000000L)
        {
            for(int j = III; j < ll1; j++)
            {
                l2 = (long)actionevent[j][(int)(l3 & 0xffffffffL)] & 65535L ^ l2 & 0xffffffffffff0000L;
                l6 = (long)(j << -351) & 0xffffffffL ^ l6 & 0xffffffff00000000L;
                l1 = (long)((int)(l6 & 0xffffffffL) + j) & 0xffffffffL ^ l1 & 0xffffffff00000000L;
                l = (long)((int)(l1 & 0xffffffffL) + (int)(l3 & 0xffffffffL)) << 16 & 0xffffffff0000L ^ l & 0xffff00000000ffffL;
                l = (long)ac[(int)((l & 0xffffffff0000L) >> 16)] & 65535L ^ l & 0xffffffffffff0000L;
                if((char)(int)(l2 & 65535L) != (char)(int)(l & 65535L))
                {
                    l = (long)III << 50 & 0x4000000000000L ^ l & 0xfffbffffffffffffL;
                }
            }

        }

    }