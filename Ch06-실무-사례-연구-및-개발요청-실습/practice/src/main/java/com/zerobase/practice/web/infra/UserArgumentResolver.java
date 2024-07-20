package com.zerobase.practice.web.infra;

import com.zerobase.practice.domain.entity.User;
import com.zerobase.practice.domain.repository.UserRepository;
import com.zerobase.practice.web.infra.exception.ZeroBaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static com.zerobase.practice.web.infra.exception.ExceptionCode.INVALID_HEADER;
import static com.zerobase.practice.web.infra.exception.ExceptionCode.USER_NOT_FOUND;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    private final String USER_HEADER = "X-USER-ID";
    private final UserRepository userRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // FIXME 조건 추가해보기
        // 현재 파라미터를 resolver이 지원하는지에 대한 boolean을 리턴합니다.
        return parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // FIXME 유저 객체 조회하기
        // 실제로 바인딩을 할 객체를 리턴
        HttpServletRequest httpServletRequest = (HttpServletRequest) webRequest.getNativeRequest();
        String userId = httpServletRequest.getHeader(USER_HEADER);

        if(userId == null) {
            throw new ZeroBaseException(INVALID_HEADER);
        }

        User user = userRepository.findById(Long.valueOf(userId))
                .orElseThrow(() -> new ZeroBaseException(USER_NOT_FOUND));

        return user;
    }
}