package me.dong.removeconditionalstatement.discount.step3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dong.removeconditionalstatement.discount.Discount;
import me.dong.removeconditionalstatement.discount.DiscountRequest;
import me.dong.removeconditionalstatement.discount.PaymentRequest;
import me.dong.removeconditionalstatement.discount.PaymentService;
import me.dong.removeconditionalstatement.discount.step2.Discountable;
import me.dong.removeconditionalstatement.discount.step3.repository.DiscounterRepository;

/**
 * Created by ethan.kim on 2018. 5. 13..
 */
@Service
public class PaymentService3 implements PaymentService {

    /*
    Discounter 테이블
    id  dtype  code     name  rate  amt
    1   RATE   NAVER    네이버   10   0
    2   RATE   DANAWA   다나와   15   0
    3   AMT    FANCAFE  팬카페   0    1000

    대부분의 객체는 상태가 언제나 쉽게 변하는(mutable) 객체(Entity)
    도메인 로직을 품은 객체의 상태가 정적인 경우는 거의 없다
    분기문으로 처리할 내용을 각각의 Entity 객체로 분리해서 처리하면
    분기문을 최소화하고, 자주 변하는 요구사항과 객체 상태의 변화에 대해서도 유연하게 대응할 수 있다
     */

    @Autowired
    private DiscounterRepository<AbstractDiscounter> discounterRepository;

    @Override
    public Discount getDiscount(DiscountRequest request) {
        // 상품금액
        long productAmt = request.getProductAmt();
        // 할인코드 (NAVER:네이버검색-10%, DANAWA:다나와검색-15% FANCAFE:팬카페-1000원)
        String discountCode = request.getDiscountCode();
        // 할인정책
        Discountable discountPolicy = getDiscounter(discountCode);

        // 할인금액
        long discountAmt = discountPolicy.getDiscountAmt(productAmt);
        return Discount.of(discountAmt);
    }

    @Override
    public void payment(PaymentRequest request) {
        // 상품금액
        long productAmt = request.getProductAmt();
        // 할인코드 (NAVER:네이버검색-10%, DANAWA:다나와검색-15% FANCAFE:팬카페-1000원)
        String discountCode = request.getDiscountCode();
        // 할인정책
        Discountable discountPolicy = getDiscounter(discountCode);

        // 결제금액
        long paymentAmt = productAmt - discountPolicy.getDiscountAmt(productAmt);

        // do something..
    }

    private Discountable getDiscounter(String discountCode) {
        if (discountCode == null) {
            return Discountable.NONE;
        }

        AbstractDiscounter discounter = discounterRepository.findByCode(discountCode);
        return discounter == null ? Discountable.NONE : discounter;
    }
}
