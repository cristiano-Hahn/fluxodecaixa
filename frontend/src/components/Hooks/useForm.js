import { useState } from "react";

export const useForm = (callback) => {
    const [values, setValues] = useState({});
    const [loading, setLoading] = useState(false);

    const handleChange = (event) => {
        const formValues = { ...values };
        formValues[event.target.name] = event.target.value;
        setValues(formValues);
    };

    const handleSubmit = callback => event => {
        event.preventDefault();
        setLoading(true);
        callback();
        setLoading(false);
    };

    return [{ values, loading }, handleChange, handleSubmit];
};
