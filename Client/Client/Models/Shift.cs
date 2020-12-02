using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;
using Microsoft.VisualBasic.CompilerServices;

namespace Client.Models
{
    public class Shift
    {
        [JsonPropertyName("username")]
        [NotNull]
        public string UserName { get; set; }

        [JsonPropertyName("_id")] public ObjectIDGenerator ShiftId { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("companyName")]
        public string CompanyName { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("jobTitle")]
        public string JobTitle { get; set; }

        [Required]
        [NotNull]
        [JsonPropertyName("date")]
        public DateTime Date { get; set; } = DateTime.Now;
        

        [Required, MaxLength(5,  ErrorMessage = "Start time should be written hh:mm")]
        [ValidateHour]
        [JsonPropertyName("startHour")] [NotNull]
        public string StartHour { get; set; }

        [Required, MaxLength(5,  ErrorMessage = "End time should be written hh:mm")]
        [JsonPropertyName("endHour")] [NotNull] [ValidateHour]
        public string EndHour { get; set; }

        [Required, MaxLength(70)]
        [JsonPropertyName("description")] [NotNull]
        public string Description { get; set; }

        [MaxLength(70)]
        [JsonPropertyName("requirements")] [NotNull]
        public string Requirements { get; set; }

        [Required]
        [JsonPropertyName("hourWage")] [NotNull]
        public float HourWage { get; set; }

        public override string ToString()
        {
            string s = "";
            s += UserName + " ";
            s += CompanyName + " ";
            s += JobTitle + " ";
            s += Date.ToString() + " ";
            s += HourWage + " ";
            s += StartHour + " ";
            s += EndHour + " ";
            s += Description + " ";
            s += Requirements + " ";
            return s;
        }
    }
    
    public class ValidateHour : ValidationAttribute
    {
        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            List<string> valid = new[]
            {
                ":"
            }.ToList();

            for (int i = 0; i < 10; i++)
            {
                valid.Add("i");
            }

            foreach (var x in value.ToString())
            {
                if (valid.Contains(x.ToString()))
                {
                    return ValidationResult.Success;
                }
            }
            return new ValidationResult("Valid type is HH:MM");
        }
    }
}