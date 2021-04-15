package com.google.android.gms.internal;

import java.io.IOException;

public final class adg {
    private final byte[] buffer;
    private int zzcse;
    private int zzcsf;
    private int zzcsg;
    private int zzcsh;
    private int zzcsi;
    private int zzcsj = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int zzcsk;
    private int zzcsl = 64;
    private int zzcsm = 67108864;

    private adg(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzcse = i;
        this.zzcsf = i2 + i;
        this.zzcsh = i;
    }

    public static adg zzH(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    private final void zzLJ() {
        this.zzcsf += this.zzcsg;
        int i = this.zzcsf;
        int i2 = this.zzcsj;
        if (i > i2) {
            this.zzcsg = i - i2;
            this.zzcsf = i - this.zzcsg;
            return;
        }
        this.zzcsg = 0;
    }

    private final byte zzLL() throws IOException {
        int i = this.zzcsh;
        if (i != this.zzcsf) {
            byte[] bArr = this.buffer;
            this.zzcsh = i + 1;
            return bArr[i];
        }
        throw ado.zzLQ();
    }

    public static adg zzb(byte[] bArr, int i, int i2) {
        return new adg(bArr, 0, i2);
    }

    private final void zzcq(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzcsh;
            int i3 = i2 + i;
            int i4 = this.zzcsj;
            if (i3 > i4) {
                zzcq(i4 - i2);
                throw ado.zzLQ();
            } else if (i <= this.zzcsf - i2) {
                this.zzcsh = i2 + i;
            } else {
                throw ado.zzLQ();
            }
        } else {
            throw ado.zzLR();
        }
    }

    public final int getPosition() {
        return this.zzcsh - this.zzcse;
    }

    public final byte[] readBytes() throws IOException {
        int zzLF = zzLF();
        if (zzLF < 0) {
            throw ado.zzLR();
        } else if (zzLF == 0) {
            return C0483ads.zzcsI;
        } else {
            int i = this.zzcsf;
            int i2 = this.zzcsh;
            if (zzLF <= i - i2) {
                byte[] bArr = new byte[zzLF];
                System.arraycopy(this.buffer, i2, bArr, 0, zzLF);
                this.zzcsh += zzLF;
                return bArr;
            }
            throw ado.zzLQ();
        }
    }

    public final String readString() throws IOException {
        int zzLF = zzLF();
        if (zzLF >= 0) {
            int i = this.zzcsf;
            int i2 = this.zzcsh;
            if (zzLF <= i - i2) {
                String str = new String(this.buffer, i2, zzLF, adn.UTF_8);
                this.zzcsh += zzLF;
                return str;
            }
            throw ado.zzLQ();
        }
        throw ado.zzLR();
    }

    public final int zzLA() throws IOException {
        if (this.zzcsh == this.zzcsf) {
            this.zzcsi = 0;
            return 0;
        }
        this.zzcsi = zzLF();
        int i = this.zzcsi;
        if (i != 0) {
            return i;
        }
        throw new ado("Protocol message contained an invalid tag (zero).");
    }

    public final long zzLB() throws IOException {
        return zzLG();
    }

    public final int zzLC() throws IOException {
        return zzLF();
    }

    public final boolean zzLD() throws IOException {
        return zzLF() != 0;
    }

    public final long zzLE() throws IOException {
        long zzLG = zzLG();
        return (-(zzLG & 1)) ^ (zzLG >>> 1);
    }

    public final int zzLF() throws IOException {
        byte b;
        int i;
        byte zzLL = zzLL();
        if (zzLL >= 0) {
            return zzLL;
        }
        byte b2 = zzLL & Byte.MAX_VALUE;
        byte zzLL2 = zzLL();
        if (zzLL2 >= 0) {
            i = zzLL2 << 7;
        } else {
            b2 |= (zzLL2 & Byte.MAX_VALUE) << 7;
            byte zzLL3 = zzLL();
            if (zzLL3 >= 0) {
                i = zzLL3 << 14;
            } else {
                b2 |= (zzLL3 & Byte.MAX_VALUE) << 14;
                byte zzLL4 = zzLL();
                if (zzLL4 >= 0) {
                    i = zzLL4 << 21;
                } else {
                    byte b3 = b2 | ((zzLL4 & Byte.MAX_VALUE) << 21);
                    byte zzLL5 = zzLL();
                    b = b3 | (zzLL5 << 28);
                    if (zzLL5 < 0) {
                        for (int i2 = 0; i2 < 5; i2++) {
                            if (zzLL() >= 0) {
                                return b;
                            }
                        }
                        throw ado.zzLS();
                    }
                    return b;
                }
            }
        }
        b = b2 | i;
        return b;
    }

    public final long zzLG() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzLL = zzLL();
            j |= ((long) (zzLL & Byte.MAX_VALUE)) << i;
            if ((zzLL & 128) == 0) {
                return j;
            }
        }
        throw ado.zzLS();
    }

    public final int zzLH() throws IOException {
        return (zzLL() & 255) | ((zzLL() & 255) << 8) | ((zzLL() & 255) << 16) | ((zzLL() & 255) << 24);
    }

    public final long zzLI() throws IOException {
        byte zzLL = zzLL();
        byte zzLL2 = zzLL();
        return ((((long) zzLL2) & 255) << 8) | (((long) zzLL) & 255) | ((((long) zzLL()) & 255) << 16) | ((((long) zzLL()) & 255) << 24) | ((((long) zzLL()) & 255) << 32) | ((((long) zzLL()) & 255) << 40) | ((((long) zzLL()) & 255) << 48) | ((((long) zzLL()) & 255) << 56);
    }

    public final int zzLK() {
        int i = this.zzcsj;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.zzcsh;
    }

    public final void zza(adp adp) throws IOException {
        int zzLF = zzLF();
        if (this.zzcsk < this.zzcsl) {
            int zzcn = zzcn(zzLF);
            this.zzcsk++;
            adp.zza(this);
            zzcl(0);
            this.zzcsk--;
            zzco(zzcn);
            return;
        }
        throw ado.zzLT();
    }

    public final void zza(adp adp, int i) throws IOException {
        int i2 = this.zzcsk;
        if (i2 < this.zzcsl) {
            this.zzcsk = i2 + 1;
            adp.zza(this);
            zzcl((i << 3) | 4);
            this.zzcsk--;
            return;
        }
        throw ado.zzLT();
    }

    public final void zzcl(int i) throws ado {
        if (this.zzcsi != i) {
            throw new ado("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzcm(int i) throws IOException {
        int zzLA;
        int i2 = i & 7;
        if (i2 == 0) {
            zzLF();
            return true;
        } else if (i2 == 1) {
            zzLI();
            return true;
        } else if (i2 == 2) {
            zzcq(zzLF());
            return true;
        } else if (i2 == 3) {
            do {
                zzLA = zzLA();
                if (zzLA == 0) {
                    break;
                }
            } while (zzcm(zzLA));
            zzcl(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzLH();
                return true;
            }
            throw new ado("Protocol message tag had invalid wire type.");
        }
    }

    public final int zzcn(int i) throws ado {
        if (i >= 0) {
            int i2 = i + this.zzcsh;
            int i3 = this.zzcsj;
            if (i2 <= i3) {
                this.zzcsj = i2;
                zzLJ();
                return i3;
            }
            throw ado.zzLQ();
        }
        throw ado.zzLR();
    }

    public final void zzco(int i) {
        this.zzcsj = i;
        zzLJ();
    }

    public final void zzcp(int i) {
        zzq(i, this.zzcsi);
    }

    public final byte[] zzp(int i, int i2) {
        if (i2 == 0) {
            return C0483ads.zzcsI;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzcse + i, bArr, 0, i2);
        return bArr;
    }

    /* access modifiers changed from: 0000 */
    public final void zzq(int i, int i2) {
        int i3 = this.zzcsh;
        int i4 = this.zzcse;
        if (i > i3 - i4) {
            int i5 = i3 - i4;
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(i5);
            throw new IllegalArgumentException(sb.toString());
        } else if (i >= 0) {
            this.zzcsh = i4 + i;
            this.zzcsi = i2;
        } else {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
    }
}
