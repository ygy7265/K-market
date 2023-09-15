    document.getElementById('category1').addEventListener('change', function() {
        var selectedCategory1 = this.value;
        var category2Select = document.getElementById('category2');

        // 선택된 1차 분류 값에 따라 2차 분류 옵션을 필터링
        for (var i = 0; i < category2Select.options.length; i++) {
            var option = category2Select.options[i];
            var cate2Value = option.value;

            // 선택된 1차 분류 값과 2차 분류 값 비교
            if (selectedCategory1 === cate2Value) {
                option.style.display = ''; // 보이기
            } else {
                option.style.display = 'none'; // 숨기기
            }
        }
    });