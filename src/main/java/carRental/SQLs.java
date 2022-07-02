package carRental;

public class SQLs {

    static final String CREATE_TEST_TABLE = """
            create table if not exists test (
                id int not null auto_increment,
                title varchar(100) not null,
                primary key (id)
            )
            """;


    static final String INSERT_SIMPLE_TEST = """
            insert into test (title)
            values ('Test1')
            """;

    static final String INSERT_CUSTOMERS = """
                        insert into customers (
                        id varchar(64) not null,
                        first_name varchar(64) not null,
                        last_name varchar(64) not null,
                        birth_date date not null,
                        phone_number varchar(9) not null,
                        licence int not null,
                        customer_password varchar(64) not null,
                        customer_email varchar(64) not null,
                        values (
                        'tester', 'Test', 'Testowy', '1991-01-01', '111111111', 1, 'tester11', 'tester@gmail.com'))
            """;

    /* static final String INSERT_SIMPLE_TEST = """
            insert into customers (
            id varchar(64) not null,
            first_name varchar(64) not null,
            last_name varchar(64) not null,
            birth_date date not null,
            phone_number varchar(9) not null,
            licence int not null,
            customer_password varchar(64) not null,
            customer_email varchar(64) not null,
            values (
            'tester', 'Test', 'Testowy', '1991-01-01', '111111111', 1, 'tester11', 'tester@gmail.com')
            """;

     */

}