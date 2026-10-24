/* Задача 3 блок 2 практика 13 */
public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String apartment;

    public void parseWithSplit(String address) {
        String[] parts = address.split(",");
        country   = parts[0].trim();
        region    = parts[1].trim();
        city      = parts[2].trim();
        street    = parts[3].trim();
        house     = parts[4].trim();
        apartment = parts[5].trim();
    }

    public void parseWithTokenizer(String address) {
        java.util.StringTokenizer st = new java.util.StringTokenizer(address, ",.;-");
        country   = st.nextToken().trim();
        region    = st.nextToken().trim();
        city      = st.nextToken().trim();
        street    = st.nextToken().trim();
        house     = st.nextToken().trim();
        apartment = st.nextToken().trim();
    }

    @Override
    public String toString() {
        return "Address{country='" + country + "', region='" + region +
                "', city='" + city + "', street='" + street +
                "', house='" + house + "', apartment='" + apartment + "'}";
    }

    public static void main(String[] args) {
        String[] samples = {
                "Россия, Московская область, Москва, ул. Ленина, 10, 25",
                "Россия; Татарстан; Казань; ул. Баумана; 5; 12",
                "Россия. Краснодарский край. Сочи. ул. Морская. 7. 3",
                "Россия - Свердловская область - Екатеринбург - ул. Мира - 1 - 100"
        };

        for (String s : samples) {
            Address a1 = new Address();
            a1.parseWithSplit(s);
            System.out.println("split():   " + a1);

            Address a2 = new Address();
            a2.parseWithTokenizer(s);
            System.out.println("tokenizer: " + a2);
        }
    }
}