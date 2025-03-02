import { TSignInDto, TSignUpEmployeeDto, TSignUpVisitorDto } from "@/entities/profiles";
import { TValidationErrors } from "@/shared/types";

export type TSignUpEmployeeValidationErrors = TValidationErrors<TSignUpEmployeeDto>;

export type TSignUpVisitorValidationErrors = TValidationErrors<TSignUpVisitorDto>;

export type TSignInValidationErrors = TValidationErrors<TSignInDto>;
