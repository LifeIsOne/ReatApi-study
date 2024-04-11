package shop.mtcoding.blog;

import org.junit.jupiter.api.Test;
import shop.mtcoding.blog._core.utils.JwtUtil;
import shop.mtcoding.blog.board.Board;
import shop.mtcoding.blog.user.User;


public class JwtUtilTest {

    @Test
    public void boardSave_test() {
        // given
        Board board = Board.builder()
                .id(1)
                .title("제목")
                .content("내용")
                .build();

        // when
        String jwt = JwtUtil.create(board);
        System.out.println(jwt);
        // then
    }
    @Test
    public void login_test() {
        // given
        User user = User.builder()
                .id(1)
                .username("ssar")
                .password("1234")
                .build();

        // when
        String jwt = JwtUtil.create(user);
        System.out.println(jwt);
        // then
    }
    @Test
    public void boardUpdate_test() {
        // given
        User user = User.builder()
                .id(1)
                .username("ssar")
                .password("1234")
                .build();

        // when
        String jwt = JwtUtil.create(user);
        System.out.println(jwt);
        // then
    }
    @Test
    public void boardDelete_test() {
        // given
        User user = User.builder()
                .id(1)
                .username("ssar")
                .password("1234")
                .build();

        // when
        String jwt = JwtUtil.create(user);
        System.out.println(jwt);
        // then
    }
}