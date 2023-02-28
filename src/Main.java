class BankAccount {

    protected int amount; // создайте переменную int amount. Доступ к переменной должен быть только из наследников и классов в текущем пакете
    protected String currency; // создайте переменную Strint currency. Доступ к переменной должен быть только из наследников и классов в текущем пакете

    public void replenishBalance(int amount) {
        amount += amount; // реализуйте метод. Он общий для всех наследников
        System.out.println("Счёт пополнен на " + amount + " " + currency);
    }
    public void withdrawCash(int amount) {}
    public void showBalance() {}
}

class DebitAccount extends BankAccount {  /* унаследуйте класс от BankAccount */

    DebitAccount(int amount, String currency) {
        if (amount < 0){ // если amount < 0, вывести сообщение "Баланс дебетового счета не может быть меньше 0"
            System.out.println("Баланс дебетового счета не может быть меньше 0");
        } else {
            super.amount = amount;
            super.currency = currency; // иначе присвоить переменным amount и currency значения, переданные в конструкторе
        }
    }
    @Override
    public void withdrawCash(int amount) {
        if (amount < this.amount){ // если на счету достаточно денег
            this.amount -= amount; // вычесть amount из amount класса
            System.out.println("Вы сняли " + amount + " " + currency); // вывести сообщение "Вы сняли {amount} {currency}"
        } else {
            System.out.println("У вас недостаточно средств для снятия суммы " + amount + " " + currency);    // иначе вывести сообщение "У вас недостаточно средств для снятия суммы {amount} {currency}"
        }
    }
    @Override
    public void showBalance() {
        System.out.println("На вашем счету осталось " + amount + " " + currency); // вывести сообщение "На вашем счету осталось {amount} {currency}"
    }
}

class CreditAccount extends BankAccount { // создайте класс CreditAccount, который будет наследоваться от класса BankAccount

    private int creditLimit; // создайте переменную int creditLimit. Переменная должна быть доступна только в пределах класса CreditAccount

    CreditAccount (int amount, String currency, int creditLimit){ // создайте конструктор, который принимает на вход переменные (int amount, String currency, int creditLimit) и присваивает их значения переменным класса
        super.amount = amount;
        super.currency = currency;
        this.creditLimit = creditLimit;
    }
    @Override
    public void withdrawCash(int amount) {  // переопределите метод withdrawCash(int amount)
        if (amount - this.amount > creditLimit){  // если после снятия наличных будет превышен кредитный лимит
            System.out.println("У вас недостаточно средств для снятия суммы " + amount + " " + currency);// выведите сообщение "У вас недостаточно средств для снятия суммы {amount} {currency}"
        } else { // иначе уменьшить сумму на счёте и вывести сообщение "Вы сняли {amount} {currency}"
            this.amount -= amount;
            System.out.println("Вы сняли " + amount + " " + currency);
        }
    }
    @Override
    public  void showBalance() {  // переопределите метод showBalance()
        if (amount >= 0){
            System.out.println("На вашем счету " + amount + " " + currency); // если на счету положительная сумма, то выведите сообщение "На вашем счету осталось {amount} {currency}",
        } else { // иначе "Ваша задолженность по кредитному счету составялет {amount} {currency}"
            System.out.println("Ваша задолженность по кредитному счету составялет " + Math.abs(amount) + " " + currency);
        }
    }
}










