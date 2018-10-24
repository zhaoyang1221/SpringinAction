package spittr.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <p>Title: SpittleNotFoundException</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-24
 **/
@ResponseStatus(value = HttpStatus.NOT_FOUND,
                reason = "Spittle Not Found")
public class SpittleNotFoundException extends RuntimeException {
}