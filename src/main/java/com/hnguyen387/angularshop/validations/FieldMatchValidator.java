package com.hnguyen387.angularshop.validations;

import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>{
	// tên các thuộc tính (propertyName)
	private String firstFieldName;
    private String secondFieldName;
    
	@Override
	public void initialize(final FieldMatch constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		/*
		 * BeanWrapperImpl là một lớp của Spring được sử dụng để thao tác các thuộc tính của đối tượng Java (beans)
		 * Lớp này cho phép bạn lấy hoặc thiết lập thuộc tính dựa trên tên của chúng
		 * value: Đối tượng mà trên đó ràng buộc validation đang được kiểm tra
		 * */
		final BeanWrapperImpl beanWrapper = new BeanWrapperImpl(value);
		//Lấy Giá Trị Của Các Trường
        final var firstObj = beanWrapper.getPropertyValue(firstFieldName);
        final var secondObj = beanWrapper.getPropertyValue(secondFieldName);
        //Kiểm Tra Tính Hợp Lệ
        boolean valid = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        //Xử Lý Khi Không Hợp Lệ
        if (!valid) {
        	//ngăn không cho các thông báo vi phạm ràng buộc mặc định được tạo
            context.disableDefaultConstraintViolation();
            //xây dựng một thông báo vi phạm ràng buộc mới
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
            		//nói rằng lỗi liên quan đến trường firstFieldName
                   .addPropertyNode(firstFieldName)
                   //thêm vi phạm ràng buộc mới vào context
                   .addConstraintViolation();
        }
        return valid;
	}

}
