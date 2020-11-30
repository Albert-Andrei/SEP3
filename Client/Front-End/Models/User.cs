using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;

namespace AndriuhaAssignment.Models
{
    public class User
    {
        [JsonPropertyName("username")]
        [Required, MaxLength(30)]
        [NotNull]
        public string UserName { get; set; }

        [Required, MaxLength(30), MinLength(8, ErrorMessage = "The password should be longer then 8")]
        [NotNull]
        [JsonPropertyName("password")]
        public string Password { get; set; }

        [JsonPropertyName("_id")] public ObjectIDGenerator UserId { get; set; }

        [JsonPropertyName("securityLevel")] public int SecurityLevel { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("firstName")]
        public string FirstName { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("lastName")]
        public string LastName { get; set; }

        [Required, MaxLength(15)]
        [ValidatePhoneNr]
        [NotNull]
        [JsonPropertyName("phoneNr")]
        public string PhoneNr { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("emali")]
        public string Email { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("city")]
        public string City { get; set; }

        [MinLength(1, ErrorMessage = "Select a type.")]
        [JsonPropertyName("userType")]
        public string UserType { get; set; }

        private class ValidatePhoneNr : ValidationAttribute
        {
            protected override ValidationResult IsValid(object value, ValidationContext validationContext)
            {
                bool validator = true;

                List<string> valid = new[]
                {
                    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "(", ")"
                }.ToList();

                foreach (var a in value.ToString())
                {
                    Console.Out.WriteLine(value.ToString());
                    Console.Out.WriteLine(a);
                    Console.Out.WriteLine(valid.Contains(a.ToString()));
                    if (!valid.Contains(a.ToString()))
                    {
                        validator = false;
                    }

                    if (!validator)
                    {
                        Console.Out.WriteLine("opa");
                        // throw new Exception("Phone number can contain only numbers and relevant characters.");
                        // return new ValidationResult("Phone number can contain only numbers and relevant characters.");
                        return new ValidationResult("huita..");
                    }
                }
                return ValidationResult.Success;
            }
        }
    }
}