package christmas.controller;

import christmas.model.Menus;
import christmas.model.Receipt;
import christmas.service.ChristmasService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Optional;

public class ChristmasController {

    private final ChristmasService christmasService;

    public ChristmasController(ChristmasService christmasService) {
        this.christmasService = christmasService;
    }

    public void run() {
        OutputView.printStartGuidance();
        Optional<Integer> visitDate = readVisitDate();
        Optional<Menus> menus = readMenus();
        if (visitDate.isEmpty() || menus.isEmpty()) {
            return;
        }

        Receipt receipt = christmasService.calculate(visitDate.get(), menus.get());
        OutputView.printReceipt(receipt);
    }

    private Optional<Integer> readVisitDate() {
        for (int attempt = 0; attempt < 3; attempt++) {
            try {
                OutputView.printVisitDateGuidance();
                return Optional.of(InputView.readVisitDate());
            } catch (RuntimeException e) {
                OutputView.printErrorMessage(e);
            }
        }
        return Optional.empty();
    }

    private Optional<Menus> readMenus() {
        for (int attempt = 0; attempt < 3; attempt++) {
            try {
                OutputView.printMenusGuidance();
                return Optional.of(InputView.readMenus());
            } catch (RuntimeException e) {
                OutputView.printErrorMessage(e);
            }
        }
        return Optional.empty();
    }
}
