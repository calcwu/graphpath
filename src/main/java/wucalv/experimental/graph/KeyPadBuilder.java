package wucalv.experimental.graph;

/**
 * User: wucalv
 * Date: 6/27/15 10:47 PM
 */
public class KeyPadBuilder {

    private KeyPad keyPad = new KeyPad();


    public KeyPadBuilder append(String... rows) {
        for(String s : rows) {
            keyPad.buildRowsByChar(s);
        }
        return this;
    }

    public KeyPad build() {
        return keyPad;
    }

    /**
     *  A B C D E
     *  F G H I J
     *  K L M N O
     *    1 2 3
     *
     * @return
     */
    public static KeyPad buildDefault() {
        return new KeyPadBuilder().append("ABCDE", "FGHIJ", "KLMNO", "*123*").build();
    }
}
